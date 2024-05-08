package com.santiago.BeautySalon.Service.abstract_service;

import org.springframework.data.domain.Page;

import com.santiago.BeautySalon.utils.SortType;

public interface CrudService<request, response, Id> {

  public Page<response> getAll(int page, int size, SortType sortType);

  public response create(request request);

  public response update(request request, Id id);

  public void delete(Id id);

  public response findById(Id id);
}