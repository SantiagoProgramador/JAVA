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
public class AppointmentToPersons {
  private EserviceToAppointmentResponse eserviceToAppointmentResponse;
  private Long id;
  private LocalDateTime dateTime;
  private int duration;
  private String comments;
  private EmployeeToAppointmentResponse employeeToAppointmentResponsep;
}
