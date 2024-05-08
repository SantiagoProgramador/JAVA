package com.santiago.BeautySalon.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.santiago.BeautySalon.Dtos.Request.EserviceRequest;
import com.santiago.BeautySalon.Dtos.Response.EserviceResponse;
import com.santiago.BeautySalon.Entity.Eservice;
import com.santiago.BeautySalon.Repository.ServiceRepository;
import com.santiago.BeautySalon.Service.abstract_service.IEserviceService;
import com.santiago.BeautySalon.utils.SortType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EserviceService implements IEserviceService {

  @Autowired
  private final ServiceRepository serviceRepository;

  @Override
  public Page<EserviceResponse> getAll(int page, int size, SortType sortType) {
    if (page < 0) {
      page = 0;
    }
    Pageable pageable = null;
    switch (sortType) {
      case NONE -> pageable = PageRequest.of(page, size, null);
      case ASC -> pageable = PageRequest.of(page, size, Sort.by(Fetch_Type).ascending());
      case DESC -> pageable = PageRequest.of(page, size, Sort.by(Fetch_Type).descending());
      default -> throw new IllegalArgumentException("Unexpected value: " + sortType);
    }

    return this.serviceRepository.findAll(pageable).map(eservice -> this.EserviceToServiceResponse(eservice));
  }

  @Override
  public EserviceResponse create(EserviceRequest request) {
    Eservice eservice = new Eservice();
    BeanUtils.copyProperties(request, eservice);

    return this.EserviceToServiceResponse(this.serviceRepository.save(eservice));
  }

  @Override
  public EserviceResponse update(EserviceRequest request, Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public EserviceResponse findById(Long id) {
    return this.EserviceToServiceResponse(this.finEserviceById(id));
  }

  private EserviceResponse EserviceToServiceResponse(Eservice eservice) {
    EserviceResponse eserviceResponse = new EserviceResponse();
    BeanUtils.copyProperties(eservice, eserviceResponse);

    return eserviceResponse;
  }

  private Eservice EserviceRequestToEservice(EserviceRequest eserviceRequest) {
    Eservice eservice = new Eservice();
    BeanUtils.copyProperties(eserviceRequest, eservice);

    return eservice;
  }

  private Eservice finEserviceById(Long id) {
    return this.serviceRepository.findById(id).orElseThrow();
  }

}
