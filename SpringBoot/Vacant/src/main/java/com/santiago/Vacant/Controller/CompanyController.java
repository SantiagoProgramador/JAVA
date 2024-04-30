package com.santiago.Vacant.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santiago.Vacant.Dto.Request.CompanyRequest;
import com.santiago.Vacant.Dto.Response.CompanyResponse;
import com.santiago.Vacant.Service.interfaces.ICompanyService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/Companies")
@AllArgsConstructor
public class CompanyController {
  @Autowired
  private final ICompanyService IcompanyService;

  @GetMapping
  public ResponseEntity<Page<CompanyResponse>> showCompanies(@RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "3") int size) {

    return ResponseEntity.ok(this.IcompanyService.getAll(page - 1, size));
  }

  @PostMapping(path = "/add")
  public ResponseEntity<CompanyResponse> addCompany(@Validated @RequestBody CompanyRequest companyRequest) {

    return ResponseEntity.ok(this.IcompanyService.create(companyRequest));
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<CompanyResponse> filterById(@PathVariable String id) {
    return ResponseEntity.ok(this.IcompanyService.findById(id));
  }

  @PutMapping(path = "/update/{id}")
  public ResponseEntity<CompanyResponse> updateCompany(@PathVariable String id,
      @Validated @RequestBody CompanyRequest companyRequest) {

    return ResponseEntity.ok(this.IcompanyService.update(companyRequest, id));
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> deleteCompany(@PathVariable String id) {
    this.IcompanyService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
