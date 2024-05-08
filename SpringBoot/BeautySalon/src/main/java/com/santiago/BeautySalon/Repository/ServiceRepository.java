package com.santiago.BeautySalon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santiago.BeautySalon.Entity.Eservice;

@Repository
public interface ServiceRepository extends JpaRepository<Eservice, Long> {

}
