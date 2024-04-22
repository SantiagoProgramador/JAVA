package com.riwi.Products.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.Products.Entity.Product;
import com.riwi.Products.Repository.ProductRepositoy;
import com.riwi.Products.Service.service_abstract.IProdcutService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService implements IProdcutService {
  @Autowired
  private final ProductRepositoy productRepositoy;

  @Override
  public Product saveProduct(Product product) {
    return null;
  }

  @Override
  public List<Product> getProducts() {
    return this.productRepositoy.findAll();
  }

  @Override
  public Product findProductById(Long id) {
    return null;
  }

  @Override
  public boolean deleteProduct(Long id) {
    return false;
  }

  @Override
  public Product updateProduct(Long id) {
    return null;
  }

  @Override
  public List<Product> findProducts(String name) {
    return null;
  }

}
