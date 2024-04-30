package com.santiago.Vacant.Exceptions;

public class idNotFoundException extends RuntimeException {
  private static final String ERROR_MESSAGE = "Put a correct Id you little fool, in the entity %s";

  public idNotFoundException(String entityName) {
    super(String.format(ERROR_MESSAGE, entityName));
  }
}
