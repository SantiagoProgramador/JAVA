package com.santiago.BeautySalon.Service.abstract_service;

import com.santiago.BeautySalon.Dtos.Request.ClientRequest;
import com.santiago.BeautySalon.Dtos.Response.ClientResponse;

public interface IClientService extends CrudService<ClientRequest, ClientResponse, Long> {
  public String FIELD_BY_SORT = "firstname";

}
