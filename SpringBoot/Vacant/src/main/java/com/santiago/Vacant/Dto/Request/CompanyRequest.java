package com.santiago.Vacant.Dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequest {

  @Size(min = 0, max = 40, message = "The name must be below 40 chacaracters!")
  @NotBlank(message = "The message of the company must be typed!")
  private String name;

  @NotBlank(message = "The location is required!")
  private String location;

  @Size(min = 0, max = 15, message = "The contact must be below 15 characters!")
  @NotBlank(message = "The contact information is required!")
  private String contact;
}
