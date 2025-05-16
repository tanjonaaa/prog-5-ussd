package org.example;

import static org.example.mvola.Data.TANJONA_ACCOUNT;

import org.example.mvola.MvolaUssdMenu;
import org.example.ussd.model.UssdApp;

public class Main {
  public static void main(String[] args) {
    var menu = new MvolaUssdMenu(TANJONA_ACCOUNT);
    var mvolaUssdApp = new UssdApp(menu.getMenu());

    mvolaUssdApp.run();
  }
}
