package com.riwi.O;

public class CreditCardPayment implements PaymentMethod {

  @Override
  public void processPayment() {
    
    System.out.println("Credit card payment processed");
    
  }
  //LOGIC TO PAY WITH A CREDIT CARD
}
