package org.example.mvola.service;

import static org.example.mvola.Data.OFFERS;
import static org.example.mvola.Data.allAccounts;

import org.example.mvola.model.MvolaAccount;

public class MvolaService {

  public void buyOffer(MvolaAccount account, String offerName) {
    var offerPrice = OFFERS.get(offerName);
    if (offerPrice == null) {
      throw new RuntimeException("Cette offre n'existe pas");
    }

    account.setBalance(account.getBalance() - offerPrice);
  }

  public void transfer(MvolaAccount from, MvolaAccount to, double amount) {
    if (from.getBalance() < amount) {
      throw new RuntimeException("Votre solde est insuffisant pour cette opération");
    }

    from.setBalance(from.getBalance() - amount);
    to.setBalance(to.getBalance() + amount);
  }

  public void deposit(MvolaAccount account, double amount) {
    account.setBalance(account.getBalance() + amount);
  }

  public MvolaAccount findAccountByPhone(String phone) {
    return allAccounts().stream()
        .filter(acc -> acc.getPhoneNumer().equals(phone))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Le numéro que vous avez composé n'existe pas"));
  }
}
