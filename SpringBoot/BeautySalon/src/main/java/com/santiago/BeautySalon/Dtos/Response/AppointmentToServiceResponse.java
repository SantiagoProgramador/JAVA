package com.santiago.BeautySalon.Dtos.Response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AppointmentToServiceResponse {
  private Long id;
  private LocalDateTime dateTime;
  private int duration;
  private String comments;
  private ClientToAppointmentResponse clientToAppointmentResponse;
  private EmployeeToAppointmentResponse employeeToAppointmentResponse;
  private EserviceToAppointmentResponse eserviceToAppointmentResponse;
}
