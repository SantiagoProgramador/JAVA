package com.riwi.I;

public class Rectangle extends Shape {
  private double height;
  private double width;

  public Rectangle(double height, double width) {
    this.height = height;
    this.width = width;
    calculateArea();
  }

  @Override
  public void calculateArea() {
    area = height * width;
  }
}
