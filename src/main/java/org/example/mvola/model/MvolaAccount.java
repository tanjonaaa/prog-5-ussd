package org.example.mvola.model;

import lombok.Getter;

@Getter
public class MvolaAccount {
  private final String name;
  private final String phoneNumer;
  private final String secretCode;
  private double balance;

  public MvolaAccount(String name, String phoneNumer, String secretCode) {
    this.name = name;
    this.phoneNumer = phoneNumer;
    this.secretCode = secretCode;
    this.balance = 0;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }
}
