package com.santiago.Vacant.Service.interfaces;

import org.springframework.data.domain.Page;

public interface CrudService<request, response, Id> {

  public Page<response> getAll(int page, int size);

  public response create(request request);

  public response update(request request, Id id);

  public void delete(Id id);

  public response findById(Id id);
}
