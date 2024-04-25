package main.java.com.santiago.Vacant.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.com.santiago.Vacant.Entity.Vacant;

public interface VacantRepository extends JpaRepository<Vacant, Long> {

}
