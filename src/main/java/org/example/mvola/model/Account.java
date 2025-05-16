package org.example.mvola.model;

import lombok.Getter;

@Getter
public class Account {
  private final String name;
  private final String phoneNumer;
  private double balance;

  public Account(String name, String phoneNumer) {
    this.name = name;
    this.phoneNumer = phoneNumer;
    this.balance = 0;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }
}
