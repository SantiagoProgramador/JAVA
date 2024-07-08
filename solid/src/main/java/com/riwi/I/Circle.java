package com.riwi.I;

public class Circle extends Shape {
  private double radius;

  public Circle(double radius) {
    this.radius = radius;
    calculateArea();

  }

  @Override
  public void calculateArea() {
    area = Math.PI * radius * radius;
  }
}
