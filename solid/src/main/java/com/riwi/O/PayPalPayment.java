package com.riwi.O;

public class PayPalPayment implements PaymentMethod {

  @Override
  public void processPayment() {
    System.out.println("PayPal payment processed");
  }
  // LOGIC TO PAY WITH PAYPAL
}
