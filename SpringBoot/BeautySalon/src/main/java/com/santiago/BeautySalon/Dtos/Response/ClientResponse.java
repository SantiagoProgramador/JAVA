package com.santiago.BeautySalon.Dtos.Response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ClientResponse {
  private Long id;

  private String firstName;

  private String lastName;

  private String phone;

  private String email;

  private List<AppointmentToPersons> appointmentsToPersons;
}
