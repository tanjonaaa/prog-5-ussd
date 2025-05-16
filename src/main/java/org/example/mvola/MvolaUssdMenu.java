package org.example.mvola;

import static org.example.mvola.Data.OFFERS;

import java.util.List;
import java.util.Scanner;
import lombok.Data;
import org.example.mvola.model.MvolaAccount;
import org.example.mvola.service.MvolaService;
import org.example.ussd.model.Menu;

@Data
public class MvolaUssdMenu {
  private final MvolaAccount account;
  private final MvolaService mvolaService = new MvolaService();
  private final Scanner scanner = new Scanner(System.in);

  public Menu getMenu() {
    return new Menu(
        "Menu principal",
        List.of(
            new Menu(
                "Afficher le solde",
                () -> System.out.println("Votre solde est de " + account.getBalance())),
            new Menu("Faire un dépôt", this::depositAction),
            new Menu("Acheter une offre", getOffersMenu()),
            new Menu("Transferer de l'argent", this::transferAction)));
  }

  private void depositAction() {
    System.out.println("Combien souhaitez-vous déposer ?");
    System.out.print("> ");
    var input = scanner.nextLine();
    mvolaService.deposit(account, Integer.parseInt(input));
    System.out.println("Dépôt résussi, votre solde est de " + account.getBalance());
  }

  private List<Menu> getOffersMenu() {
    return OFFERS.keySet().stream()
        .map(
            (offer) ->
                new Menu(
                    offer,
                    () -> {
                      checkSecretCode(
                          scanner,
                          () -> {
                            mvolaService.buyOffer(account, offer);
                            System.out.println(
                                "Votre achat de "
                                    + offer
                                    + " est reussi votre nouveau solde est de "
                                    + account.getBalance());
                          });
                    }))
        .toList();
  }

  private void transferAction() {
    System.out.println("Entrez le numéro pour le transfert: ");
    System.out.print("> ");
    var phoneNumer = scanner.nextLine();
    try {
      var destAccount = mvolaService.findAccountByPhone(phoneNumer);
      System.out.println("Combien souhaitez-vous transférer ?");
      System.out.print("> ");
      var amount = scanner.nextLine();
      checkSecretCode(
          scanner,
          () -> {
            mvolaService.transfer(account, destAccount, Integer.parseInt(amount));
            System.out.println("Transfert résussi, votre solde est de " + account.getBalance());
          });
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    }
  }

  private void checkSecretCode(Scanner scanner, Runnable onSuccess) {
    var attemptsNb = 3;
    while (attemptsNb > 0) {
      System.out.println("Rentrez votre code secret pour confirmer: ");
      System.out.print("> ");
      var input = scanner.nextLine();
      if (input.equals(account.getSecretCode())) {
        onSuccess.run();
        return;
      }
      attemptsNb--;
      System.out.println("Code incorrect, il vous reste " + attemptsNb + " tentatives");
    }
  }
}
