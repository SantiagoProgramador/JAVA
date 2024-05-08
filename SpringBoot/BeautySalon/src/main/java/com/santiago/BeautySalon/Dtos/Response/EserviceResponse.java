package com.santiago.BeautySalon.Dtos.Response;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class EserviceResponse {
  private Long id;
  private String name;
  private String description;
  private BigDecimal price;
  private List<AppointmentToServiceResponse> appointmentToServiceResponses;
}
