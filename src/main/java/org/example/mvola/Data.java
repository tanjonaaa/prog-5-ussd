package org.example.mvola;

import java.util.List;
import org.example.mvola.model.Account;

public class Data {
  public static final Account TANJONA_ACCOUNT = new Account("Tanjona", "0341111111");
  public static final Account ANTE_ACCOUNT = new Account("Ante", "0342222222");
  public static final Account NATHA_ACCOUNT = new Account("Natha", "0343333333");

  public static List<Account> allAccounts() {
    return List.of(TANJONA_ACCOUNT, ANTE_ACCOUNT, NATHA_ACCOUNT);
  }
}
