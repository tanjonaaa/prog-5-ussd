package org.example.mvola.service;

import org.example.mvola.Data;
import org.example.mvola.model.Account;

public class MVolaService {

  public void transfer(Account from, Account to, double amount) {
    if (from.getBalance() < amount) {
      throw new RuntimeException("Votre solde est insuffisant pour cette opération");
    }

    from.setBalance(from.getBalance() - amount);
    to.setBalance(to.getBalance() + amount);
  }

  public void deposit(Account account, double amount) {
    account.setBalance(account.getBalance() + amount);
  }

  public Account findAccountByPhone(String phone) {
    return Data.allAccounts().stream()
        .filter(acc -> acc.getPhoneNumer().equals(phone))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Le numéro que vous avez composé n'existe pas"));
  }
}
