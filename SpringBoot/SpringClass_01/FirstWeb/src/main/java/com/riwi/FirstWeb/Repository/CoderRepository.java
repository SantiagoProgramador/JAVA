package com.riwi.FirstWeb.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.riwi.FirstWeb.Entity.Coder;

@Repository
public interface CoderRepository extends JpaRepository<Coder,Long>{

} 
