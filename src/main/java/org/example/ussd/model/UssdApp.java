package org.example.ussd.model;

import java.util.Scanner;
import lombok.Setter;

@Setter
public class UssdApp {
  private final Menu mainMenu;
  private Menu currentMenu;
  private final Scanner scanner = new Scanner(System.in);

  public UssdApp(Menu mainMenu) {
    this.mainMenu = mainMenu;
    this.currentMenu = mainMenu;
  }

  public void run() {
    while (true) {
      System.out.println(currentMenu);
      System.out.print("> ");
      var input = scanner.nextLine();
      switch (input) {
        case "*" -> goBack();
        case "**" -> goToMainMenu();
        default -> {
          setCurrentMenu(currentMenu.getChild(Integer.parseInt(input)));
          if (currentMenu.isAction()) {
            currentMenu.getAction().run();
            goBack();
          }
        }
      }
    }
  }

  private void goBack() {
    if (currentMenu.getParent() != null) {
      currentMenu = currentMenu.getParent();
    }
  }

  private void goToMainMenu() {
    setCurrentMenu(mainMenu);
  }
}
