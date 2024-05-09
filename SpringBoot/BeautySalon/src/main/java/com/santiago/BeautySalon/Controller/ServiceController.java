package com.santiago.BeautySalon.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.santiago.BeautySalon.Dtos.Response.EserviceResponse;
import com.santiago.BeautySalon.Service.abstract_service.IEserviceService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping(path = "/Services")
@AllArgsConstructor
public class ServiceController {
  @Autowired
  private final IEserviceService iEserviceService;

  // @GetMapping(path = "/{id}")
  // public ResponseEntity<EserviceResponse> showService(@RequestParam Long id){

  // }

}
