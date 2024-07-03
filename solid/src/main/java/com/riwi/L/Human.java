package com.riwi.L;

public class Human implements Eater, Worker {

  @Override
  public void work() {
    System.out.println("Working...");
  }

  @Override
  public void eater() {
    System.out.println("Eating...");
  }

}
