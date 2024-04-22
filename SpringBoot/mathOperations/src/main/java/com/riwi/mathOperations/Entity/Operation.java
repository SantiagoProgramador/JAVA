package com.riwi.mathOperations.Entity;

public class Operation {
  private int num_1;
  private int num_2;

  public Operation(int num_1, int num_2) {
    this.num_1 = num_1;
    this.num_2 = num_2;
  }

  public Operation() {
  }

  public int getNum_1() {
    return num_1;
  }

  public void setNum_1(int num_1) {
    this.num_1 = num_1;
  }

  public int getNum_2() {
    return num_2;
  }

  public void setNum_2(int num_2) {
    this.num_2 = num_2;
  }

  @Override
  public String toString() {
    return "Operation [num_1=" + num_1 + ", num_2=" + num_2 + "]";
  }
}
