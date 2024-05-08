package com.santiago.BeautySalon.Dtos.Response;

import com.santiago.BeautySalon.utils.EmployeeRol;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeToAppointmentResponse {
  private Long id;

  private String firstName;

  private String lastName;

  private String email;

  private String phone;

  private EmployeeRol employeRol;
}
