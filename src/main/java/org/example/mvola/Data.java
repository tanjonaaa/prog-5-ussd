package org.example.mvola;

import java.util.List;
import java.util.Map;
import org.example.mvola.model.MvolaAccount;

public class Data {
  public static final MvolaAccount TANJONA_ACCOUNT =
      new MvolaAccount("Tanjona", "0341111111", "1234");
  public static final MvolaAccount ANTE_ACCOUNT = new MvolaAccount("Ante", "0342222222", "4567");
  public static final MvolaAccount NATHA_ACCOUNT = new MvolaAccount("Natha", "0343333333", "8910");
  public static final Map<String, Double> OFFERS =
      Map.of(
          "MORA 500", 500d,
          "MORA ONE", 1000d,
          "YELLOW 500", 500d,
          "YELLOW ONE", 1000d,
          "NET ONE WEEK", 3000d);

  public static List<MvolaAccount> allAccounts() {
    return List.of(TANJONA_ACCOUNT, ANTE_ACCOUNT, NATHA_ACCOUNT);
  }
}
