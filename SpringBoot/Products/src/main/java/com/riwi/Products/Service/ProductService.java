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
    return this.productRepositoy.save(product);

  }

  @Override
  public List<Product> getProducts() {
    return this.productRepositoy.findAll();
  }

  @Override
  public Product findProductById(Long id) {
    return this.productRepositoy.findById(id).orElse(null);
  }

  @Override
  public boolean deleteProduct(Long id) {
    if (findProductById(id) == null) {
      return false;
    } else
      this.productRepositoy.deleteById(id);
    return true;
  }

  @Override
  public Product updateProduct(Long id, Product product) {
    Product productUpdate = findProductById(id);
    if (productUpdate == null) {
      return null;
    }
    productUpdate = product;
    productUpdate.setId(id);
    return this.productRepositoy.save(productUpdate);
  }

  @Override
  public List<Product> findProducts(String name) {
    return this.productRepositoy.findByNameContaining(name);
  }

}
