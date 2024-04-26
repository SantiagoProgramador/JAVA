package com.santiago.Vacant.Dto.Response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponse {
  private String id;
  private String name;
  private String location;
  private String contact;
  private List<VacantResponse> vacants;

}
