package com.santiago.BeautySalon.utils.exception;

public class BadRequestException extends RuntimeException {
  public BadRequestException(String error) {
    super(error);
  }
}
