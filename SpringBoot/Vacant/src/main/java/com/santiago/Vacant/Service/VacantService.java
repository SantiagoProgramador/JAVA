package com.santiago.Vacant.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.santiago.Vacant.Dto.Request.VacantRequest;
import com.santiago.Vacant.Dto.Response.CompanyToVacantResponse;
import com.santiago.Vacant.Dto.Response.VacantResponse;
import com.santiago.Vacant.Entity.Entity.Company;
import com.santiago.Vacant.Entity.Entity.Status;
import com.santiago.Vacant.Entity.Entity.Vacant;
import com.santiago.Vacant.Exceptions.idNotFoundException;
import com.santiago.Vacant.Repository.CompanyRepository;
import com.santiago.Vacant.Repository.VacantRepository;
import com.santiago.Vacant.Service.interfaces.IVacantService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VacantService implements IVacantService {

  @Autowired
  private final VacantRepository vacantRepository;
  @Autowired
  private final CompanyRepository companyRepository;

  @Override
  public Page<VacantResponse> getAll(int page, int size) {
    if (page < 0) {
      page = 0;
    }
    Pageable pageable = PageRequest.of(page, size);
    return this.vacantRepository.findAll(pageable).map(vacantResponse -> this.vacantToVacantResponse(vacantResponse));
  }

  private VacantResponse vacantToVacantResponse(Vacant vacant) {
    VacantResponse vacantResponse = new VacantResponse();
    BeanUtils.copyProperties(vacant, vacantResponse);

    CompanyToVacantResponse companyToVacantResponse = new CompanyToVacantResponse();
    BeanUtils.copyProperties(vacant.getCompany(), companyToVacantResponse);
    vacantResponse.setCompany(companyToVacantResponse);
    return vacantResponse;
  }

  @Override
  public VacantResponse create(VacantRequest vacantRequest) {
    Company company = this.companyRepository.findById(vacantRequest.getCompanyId())
        .orElseThrow(() -> new idNotFoundException("COmpany"));

    Vacant vacant = this.vacantRequestToVacant(vacantRequest, new Vacant());
    vacant.setCompany(company);

    return this.vacantToVacantResponse(this.vacantRepository.save(vacant));

  }

  private Vacant vacantRequestToVacant(VacantRequest vacantRequest, Vacant vacant) {
    vacant.setTitle(vacantRequest.getTitle());
    vacant.setDescription(vacantRequest.getDescription());
    vacant.setStatus(Status.AVAILABLE);

    return vacant;
  }

  @Override
  public VacantResponse update(VacantRequest request, Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void delete(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'delete'");
  }

  @Override
  public VacantResponse findById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

}
