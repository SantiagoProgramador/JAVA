package com.riwi.Products.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.Products.Entity.Product;

@Repository
public interface ProductRepositoy extends JpaRepository<Product, Long> {
  public List<Product> findByNameContaining(String name);
}
