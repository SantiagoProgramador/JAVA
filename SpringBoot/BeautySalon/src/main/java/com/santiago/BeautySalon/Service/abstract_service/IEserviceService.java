package com.santiago.BeautySalon.Service.abstract_service;

import com.santiago.BeautySalon.Dtos.Request.EserviceRequest;
import com.santiago.BeautySalon.Dtos.Response.EserviceResponse;

public interface IEserviceService extends CrudService<EserviceRequest, EserviceResponse, Long> {
  public String Fetch_Type = "price";
}
