package com.riwi.O;

import java.util.HashMap;
import java.util.Map;

public class PaymentProcessor {
  private Map<String, PaymentMethod> paymentMethods = new HashMap<>();

  public PaymentProcessor() {
    // Register the known payments methods
    registerPaymentMethod("credit", new CreditCardPayment());
    registerPaymentMethod("paypal", new PayPalPayment());
  }

  public void registerPaymentMethod(String paymentType, PaymentMethod paymentMethod) {
    paymentMethods.put(paymentType, paymentMethod);
  }

  public void processPayment(String paymentType) {
    PaymentMethod paymentMethod = paymentMethods.get(paymentType);
    if (paymentMethod != null) {
      paymentMethod.processPayment();
    } else {
      System.out.println("Payment method not supported: " + paymentType);
    }
  }
}
