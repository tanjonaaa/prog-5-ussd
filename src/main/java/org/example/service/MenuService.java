package org.example.service;

public class MenuService {
  public String getMainMenu() {
    return """
           1. Consulter solde
           2. Transfert
           3. Quitter
           """;
  }

  public String getTransfertMenu() {
    return """
           -- Menu Transfert --

           1. Vers Orange Money
           2. Vers Moov Money
           3. Retour
           """;
  }
}
