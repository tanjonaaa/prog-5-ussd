package org.example.ussd.model;

import java.util.List;
import lombok.Data;

@Data
public class Menu {
  private Menu parent;
  private final String name;
  private final List<Menu> items;
  private final Runnable action;

  public Menu(String name, List<Menu> items) {
    this.name = name;
    this.items = items;
    this.action = null;

    for (Menu item : items) {
      item.setParent(this);
    }
  }

  public Menu(String name, Runnable action) {
    this.name = name;
    this.action = action;
    this.items = List.of();
  }

  public Menu getChild(int number) {
    return items.get(number - 1);
  }

  public boolean isAction() {
    return action != null;
  }

  @Override
  public String toString() {
    var messageBuilder = new StringBuilder();
    messageBuilder.append("--- ").append(name).append(" --- \n");
    for (int i = 0; i < items.size(); i++) {
      messageBuilder.append(i + 1).append(" - ").append(items.get(i).getName()).append('\n');
    }
    messageBuilder.append("* - Retour \n");
    messageBuilder.append("** - Retourner au menu principal \n");
    return messageBuilder.toString();
  }
}
