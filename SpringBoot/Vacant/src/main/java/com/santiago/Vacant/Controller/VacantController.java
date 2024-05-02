package com.santiago.Vacant.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santiago.Vacant.Dto.Request.VacantRequest;
import com.santiago.Vacant.Dto.Response.VacantResponse;
import com.santiago.Vacant.Service.interfaces.IVacantService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(path = "/Vacants")
@AllArgsConstructor
public class VacantController {
  @Autowired
  private final IVacantService IVacantService;

  @GetMapping
  public ResponseEntity<Page<VacantResponse>> showVacants(@RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "3") int size) {
    return ResponseEntity.ok(IVacantService.getAll(page - 1, size));
  }

  @PostMapping(path = "/add")
  public ResponseEntity<VacantResponse> addVacant(@RequestBody VacantRequest vacantRequest) {

    return ResponseEntity.ok(this.IVacantService.create(vacantRequest));
  }

}
