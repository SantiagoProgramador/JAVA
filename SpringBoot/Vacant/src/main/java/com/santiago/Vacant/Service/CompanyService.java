package com.santiago.Vacant.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.santiago.Vacant.Dto.Request.CompanyRequest;
import com.santiago.Vacant.Dto.Response.CompanyResponse;
import com.santiago.Vacant.Dto.Response.VacantToCompanyResponse;
import com.santiago.Vacant.Entity.Entity.Company;
import com.santiago.Vacant.Entity.Entity.Vacant;
import com.santiago.Vacant.Exceptions.idNotFoundException;
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
      page = 0;
    }

    Pageable pageable = PageRequest.of(page, size);

    return this.companyRepository.findAll(pageable)
        .map(companyResponse -> this.changeToCompanyResponse(companyResponse));
  }

  @Override
  public CompanyResponse create(CompanyRequest companyRequest) {
    Company company = this.changeToCompany(companyRequest, new Company());

    return this.changeToCompanyResponse(this.companyRepository.save(company));
  }

  @Override
  public CompanyResponse update(CompanyRequest companyRequest, String id) {
    Company company = this.findCompanyById(id);
    Company companyToUpdate = this.changeToCompany(companyRequest, company);

    return this.changeToCompanyResponse(this.companyRepository.save(companyToUpdate));
  }

  @Override
  public void delete(String id) {
    Company company = this.findCompanyById(id);

    this.companyRepository.delete(company);

  }

  @Override
  public CompanyResponse findById(String id) {
    Company company = this.findCompanyById(id);
    return this.changeToCompanyResponse(company);
  }

  private Company findCompanyById(String id) {
    return this.companyRepository.findById(id).orElseThrow(() -> new idNotFoundException("Company"));
  }

  private CompanyResponse changeToCompanyResponse(Company company) {

    CompanyResponse companyResponse = new CompanyResponse();
    BeanUtils.copyProperties(company, companyResponse);
    companyResponse.setVacants(
        company.getVacants().stream().map(vacant -> this.changeToVacantToCompany(vacant)).collect(Collectors.toList()));
    return companyResponse;
  }

  private VacantToCompanyResponse changeToVacantToCompany(Vacant vacant) {
    VacantToCompanyResponse vacantToCompany = new VacantToCompanyResponse();
    BeanUtils.copyProperties(vacant, vacantToCompany);
    return vacantToCompany;
  }

  private Company changeToCompany(CompanyRequest companyRequest, Company company) {
    company.setVacants(new ArrayList<>());
    BeanUtils.copyProperties(companyRequest, company);
    return company;
  }

}
