package org.example;

import static org.example.mvola.Data.TANJONA_ACCOUNT;

import java.util.List;
import java.util.Scanner;
import org.example.mvola.service.MVolaService;
import org.example.ussd.model.Menu;
import org.example.ussd.model.UssdApp;

public class Main {
  public static void main(String[] args) {
    var scanner = new Scanner(System.in);
    var accountService = new MVolaService();

    Runnable depositToTanjona =
        () -> {
          System.out.println("Combien souhaitez-vous déposer ?");
          System.out.print("> ");
          var input = scanner.nextLine();
          accountService.deposit(TANJONA_ACCOUNT, Integer.parseInt(input));
          System.out.println("Dépôt résussi, votre solde est de " + TANJONA_ACCOUNT.getBalance());
        };

    Runnable transferFromTanjona =
        () -> {
          System.out.println("Entrez le numéro pour le transfert: ");
          System.out.print("> ");
          var phoneNumer = scanner.nextLine();
          try {
            var destAccount = accountService.findAccountByPhone(phoneNumer);
            System.out.println("Combien souhaitez-vous transférer ?");
            System.out.print("> ");
            var amount = scanner.nextLine();
            accountService.transfer(TANJONA_ACCOUNT, destAccount, Integer.parseInt(amount));
            System.out.println(
                "Transfert résussi, votre solde est de " + TANJONA_ACCOUNT.getBalance());
          } catch (RuntimeException e) {
            System.out.println(e.getMessage());
          }
        };

    var menu =
        new Menu(
            "Menu principal",
            List.of(
                new Menu(
                    "Afficher le solde",
                    () -> System.out.println("Votre solde est de " + TANJONA_ACCOUNT.getBalance())),
                new Menu("Faire un dépôt", depositToTanjona),
                new Menu(
                    "Acheter une offre",
                    List.of(
                        new Menu(
                            "Offre pour moi",
                            List.of(
                                new Menu(
                                    "Offre jour",
                                    () ->
                                        System.out.println(
                                            "Vous avez acheté une offre journalière")),
                                new Menu(
                                    "Offre semaine",
                                    () ->
                                        System.out.println(
                                            "Vous avez acheté une offre hebdomadaire")),
                                new Menu(
                                    "Offre mois",
                                    () ->
                                        System.out.println(
                                            "Vous avez acheté une offre mensuelle")))),
                        new Menu("Offre pour un autre", List.of()))),
                new Menu("Transferer de l'argent", transferFromTanjona)));

    var app = new UssdApp(menu);
    app.run();
  }
}
