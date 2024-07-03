package com.riwi.D;

public class Database implements DataStorage {

  @Override
  public void save(String data) {
    System.out.println("Saving data to the database: " + data);
  }

}
