package com.santiago.BeautySalon.Dtos.Response;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class EserviceToAppointmentResponse {
  private Long id;
  private String name;
  private String description;
  private BigDecimal price;
}
