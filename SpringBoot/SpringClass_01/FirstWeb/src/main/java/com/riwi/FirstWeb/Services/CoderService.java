package com.riwi.FirstWeb.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

  public Coder addCoder(Coder coder) {
    return this.coderRepository.save(coder);
  }

  public Coder updateCoder(Long id, Coder coder) {
    Coder coderUpdate = findCoderById(id);

    if (coderUpdate == null) {
      return null;
    }
    coderUpdate = coder;
    return this.coderRepository.save(coderUpdate);
  }

  public Coder deleteCoder(Long id) {
    Coder coderDelete = findCoderById(id);

    if (coderDelete == null) {
      return null;
    }
    this.coderRepository.delete(coderDelete);
    return coderDelete;
  }

  public Coder findCoderById(Long id) {
    return this.coderRepository.findById(id).orElse(null);
  }

  public Page<Coder> findPaginated(int page, int size) {
    if (page < 0) {
      page = 1;
    }

    Pageable pageable = PageRequest.of(page, size);

    return this.coderRepository.findAll(pageable);
  }

}
