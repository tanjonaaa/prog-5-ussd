package org.example;

import java.util.Scanner;
import org.example.model.Session;
import org.example.service.MenuService;
import org.example.service.TransactionService;

public class UssdApp {
  private final Scanner scanner = new Scanner(System.in);
  private final Session session = new Session();
  private final MenuService menuService = new MenuService();
  private final TransactionService transactionService = new TransactionService();

  public void run() {
    session.setActive(true);

    while (session.isActive()) {
      switch (session.getCurrentMenu()) {
        case "main" -> handleMainMenu();
        case "transfert" -> handleTransfertMenu();
      }
    }
  }

  private void handleMainMenu() {
    System.out.println(menuService.getMainMenu());
    System.out.print("> ");
    String input = scanner.nextLine();

    switch (input) {
      case "1" -> System.out.println(transactionService.getBalance());
      case "2" -> session.setCurrentMenu("transfert");
      case "3" -> {
        System.out.println("Merci. À bientôt !");
        session.setActive(false);
      }
      default -> System.out.println("Option invalide.");
    }

    System.out.println();
  }

  private void handleTransfertMenu() {
    System.out.println(menuService.getTransfertMenu());
    System.out.print("> ");
    String input = scanner.nextLine();

    switch (input) {
      case "1" -> {
        System.out.print("Montant à envoyer vers Orange Money: ");
        String montant = scanner.nextLine();
        System.out.println(transactionService.transfer("Orange Money", montant));
      }
      case "2" -> {
        System.out.print("Montant à envoyer vers Moov Money: ");
        String montant = scanner.nextLine();
        System.out.println(transactionService.transfer("Moov Money", montant));
      }
      case "3" -> session.setCurrentMenu("main");
      default -> System.out.println("Option invalide.");
    }

    System.out.println();
  }
}
