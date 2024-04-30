package com.santiago.Vacant.Controller.error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.santiago.Vacant.Dto.Errors.BaseErrorResponse;
import com.santiago.Vacant.Dto.Errors.ErrorResponse;
import com.santiago.Vacant.Dto.Errors.ErrorsResponse;
import com.santiago.Vacant.Exceptions.idNotFoundException;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class badRequestController {

  @ExceptionHandler(idNotFoundException.class)
  public BaseErrorResponse IdNotFound(idNotFoundException exception) {

    return ErrorResponse.builder().message(exception.getMessage()).status(HttpStatus.BAD_REQUEST.name())
        .code(HttpStatus.BAD_REQUEST.value()).build();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public BaseErrorResponse ErrorsResponse(MethodArgumentNotValidException exception) {
    List<String> Errors = new ArrayList<>();

    exception.getAllErrors().forEach(error -> Errors.add(error.getDefaultMessage()));

    return ErrorsResponse.builder().Errors(Errors).status(HttpStatus.BAD_REQUEST.name())
        .code(HttpStatus.BAD_REQUEST.value()).build();
  }
}
