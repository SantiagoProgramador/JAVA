package com.santiago.Vacant.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
      @RequestParam(defaultValue = "1") int size) {

    return ResponseEntity.ok(this.IcompanyService.getAll(page - 1, size));
  }
}
