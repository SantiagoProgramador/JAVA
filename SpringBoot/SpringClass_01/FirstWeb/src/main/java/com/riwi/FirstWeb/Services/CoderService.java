package com.riwi.FirstWeb.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.FirstWeb.Entity.Coder;
import com.riwi.FirstWeb.Repository.CoderRepository;

@Service
public class CoderService {
  @Autowired
  private CoderRepository coderRepository;

  public List<Coder> findAll() {
    return this.coderRepository.findAll();
  }
}
