package com.santiago.BeautySalon.Service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.santiago.BeautySalon.Dtos.Request.ClientRequest;
import com.santiago.BeautySalon.Dtos.Response.AppointmentToPersons;
import com.santiago.BeautySalon.Dtos.Response.ClientResponse;
import com.santiago.BeautySalon.Dtos.Response.EmployeeResponse;
import com.santiago.BeautySalon.Dtos.Response.EmployeeToAppointmentResponse;
import com.santiago.BeautySalon.Dtos.Response.EserviceResponse;
import com.santiago.BeautySalon.Dtos.Response.EserviceToAppointmentResponse;
import com.santiago.BeautySalon.Entity.Appointment;
import com.santiago.BeautySalon.Entity.Client;
import com.santiago.BeautySalon.Repository.ClientRepository;
import com.santiago.BeautySalon.Service.abstract_service.IClientService;
import com.santiago.BeautySalon.utils.SortType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService implements IClientService {

  @Autowired
  private final ClientRepository clientRepository;

  @Override
  public Page<ClientResponse> getAll(int page, int size, SortType sortType) {
    if (page < 0) {
      page = 1;
    }
    Pageable pageable = null;

    switch (sortType) {
      case NONE -> pageable = PageRequest.of(page, size);
      case ASC -> pageable = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
      case DESC -> pageable = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
    }
    return null;
  }

  @Override
  public ClientResponse create(ClientRequest request) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }

  @Override
  public ClientResponse update(ClientRequest request, Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public ClientResponse findById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  private ClientResponse clientToClientResponse(Client client) {
    // List<AppointmentToPersons> appointmentToPersons =

    return ClientResponse.builder()
        .id(client.getId()).firstName(client.getFirstName())
        .lastName(client.getLastName()).phone(client.getPhone())
        .email(client.getEmail()).build();
  }

  private AppointmentToPersons appoinmentToAppointmentToPersons(Appointment appointment) {
    EserviceToAppointmentResponse eserviceToAppointmentResponse = new EserviceToAppointmentResponse();

    EmployeeToAppointmentResponse employeeToAppointmentResponse = new EmployeeToAppointmentResponse();
    BeanUtils.copyProperties(appointment.getEmployee(), employeeToAppointmentResponse);

    AppointmentToPersons appointmentToPersons = new AppointmentToPersons();
    BeanUtils.copyProperties(appointment, appointmentToPersons);
    appointmentToPersons.setEmployeeToAppointmentResponsep(employeeToAppointmentResponse);
    appointmentToPersons.setEserviceToAppointmentResponse(eserviceToAppointmentResponse);

    return appointmentToPersons;
  }
}
