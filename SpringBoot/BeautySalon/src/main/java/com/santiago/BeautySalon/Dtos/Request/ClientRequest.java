package com.santiago.BeautySalon.Dtos.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ClientRequest {
  private String firstName;

  private String lastName;

  private String phone;

  private String email;
}
