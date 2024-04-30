package com.santiago.Vacant.Dto.Errors;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BaseErrorResponse implements Serializable{
  private String status;
  private Integer code;

}
