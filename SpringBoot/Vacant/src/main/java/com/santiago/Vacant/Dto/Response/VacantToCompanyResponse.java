package com.santiago.Vacant.Dto.Response;

import ch.qos.logback.core.status.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacantToCompanyResponse {
  private Long id;
  private String description;
  private Status status;
  private String title;
}
