package org.example.model;

import lombok.Data;

@Data
public class Session {
  private boolean active;
  private String currentMenu = "main";
}
