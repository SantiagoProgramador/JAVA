package com.santiago.Vacant.Dto.Response;

import com.santiago.Vacant.Entity.Entity.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacantResponse {
  private Long id;
  private String description;
  private Status status;
  private String title;
  private CompanyToVacantResponse company;
}
