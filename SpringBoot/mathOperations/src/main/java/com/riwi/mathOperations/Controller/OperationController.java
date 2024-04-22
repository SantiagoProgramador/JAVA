package com.riwi.mathOperations.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.mathOperations.Entity.Operation;

@RestController
@RequestMapping("/api/v1/operations")
public class OperationController {

  @PostMapping(path = "/add")
  public String add(@RequestBody Operation operation) {
    String sum = String.valueOf(operation.getNum_1() + operation.getNum_2());
    return operation.getNum_1() + " + " + operation.getNum_2() + " = " + sum;
  }

  @PostMapping(path = "/subtract")
  public String subtract(@RequestBody Operation operation) {
    String subtractNumbers = String.valueOf(operation.getNum_1() - operation.getNum_2());
    return operation.getNum_1() + " - " + operation.getNum_2() + " = " + subtractNumbers;
  }

  @PostMapping(path = "/multiply")
  public String multiply(@RequestBody Operation operation) {
    String subtractNumbers = String.valueOf(operation.getNum_1() * operation.getNum_2());
    return operation.getNum_1() + " * " + operation.getNum_2() + " = " + subtractNumbers;
  }

  @PostMapping(path = "/divide")
  public String divide(@RequestBody Operation operation) {
    if (operation.getNum_2() == 0) {
      return "mmgvo no puedes dividir por 0 :p";
    }
    String subtractNumbers = String.valueOf(operation.getNum_1() / operation.getNum_2());

    return operation.getNum_1() + " / " + operation.getNum_2() + " = " + subtractNumbers;
  }
}
