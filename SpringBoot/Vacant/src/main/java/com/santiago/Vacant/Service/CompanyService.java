package com.santiago.Vacant.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.santiago.Vacant.Dto.Request.CompanyRequest;
import com.santiago.Vacant.Dto.Response.CompanyResponse;
import com.santiago.Vacant.Entity.Entity.Company;
import com.santiago.Vacant.Repository.CompanyRepository;
import com.santiago.Vacant.Service.interfaces.ICompanyService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyService implements ICompanyService {

  @Autowired
  private final CompanyRepository companyRepository;

  @Override
  public Page<CompanyResponse> getAll(int page, int size) {
    if (page < 0) {
      page = 1;
    }

    Pageable pageable = PageRequest.of(page, size);

    return this.companyRepository.findAll(pageable).map(companyResponse -> this.changeToCompany(companyResponse));
  }

  @Override
  public CompanyResponse create(CompanyRequest request) {

  }

  @Override
  public CompanyResponse update(CompanyRequest request, String id) {

  }

  @Override
  public void delete(String id) {

  }

  @Override
  public CompanyResponse findById(CompanyRequest request, String id) {

  }

  private CompanyResponse changeToCompany(Company company) {
    CompanyResponse companyResponse = new CompanyResponse();
    BeanUtils.copyProperties(company, companyResponse);

    return companyResponse;
  }

}
