package com.riwi.Products.Service.service_abstract;

import java.util.List;
import com.riwi.Products.Entity.Product;

public interface IProdcutService {

  public Product saveProduct(Product product);

  public List<Product> getProducts();

  public Product findProductById(Long id);

  public boolean deleteProduct(Long id);

  public Product updateProduct(Long id, Product product);

  public List<Product> findProducts(String name);

}
