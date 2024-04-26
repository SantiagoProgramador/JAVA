package com.santiago.Vacant.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santiago.Vacant.Entity.Entity.Company;

public interface CompanyRepository extends JpaRepository<Company, String> {

}
