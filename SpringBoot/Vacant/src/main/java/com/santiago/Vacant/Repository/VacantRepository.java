package com.santiago.Vacant.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santiago.Vacant.Entity.Entity.Vacant;

public interface VacantRepository extends JpaRepository<Vacant, Long> {

}
