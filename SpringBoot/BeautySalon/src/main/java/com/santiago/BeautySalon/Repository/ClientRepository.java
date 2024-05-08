package com.santiago.BeautySalon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santiago.BeautySalon.Entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
