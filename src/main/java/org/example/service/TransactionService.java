package org.example.service;

public class TransactionService {

  public String getBalance() {
    return "Votre solde est de 10 000 FCFA.";
  }

  public String transfer(String operateur, String montant) {
    return "Transfert de " + montant + " FCFA vers " + operateur + " effectué avec succès.";
  }
}
