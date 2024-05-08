package com.santiago.BeautySalon.Dtos.Request;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class EserviceRequest {
  private String name;
  private String description;
  private BigDecimal price;
  
}
