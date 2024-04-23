package com.riwi.Products.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.Products.Entity.Product;
import com.riwi.Products.Service.service_abstract.IProdcutService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/Products")
@AllArgsConstructor
public class ProductController {
  @Autowired
  private final IProdcutService iProdcutService;

  @GetMapping
  public ResponseEntity<List<Product>> ShowProducts() {

    return ResponseEntity.ok(this.iProdcutService.getProducts());
  }

  @PostMapping("/add")
  public ResponseEntity<Product> addProduct(@RequestBody Product product) {

    return new ResponseEntity<>(this.iProdcutService.saveProduct(product), HttpStatus.CREATED);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Product> ShowProduct(@PathVariable Long id) {
    return ResponseEntity.ok(this.iProdcutService.findProductById(id));
  }

  @PutMapping(path = "/update/{id}")
  public ResponseEntity<Product> productToUpdate(@PathVariable Long id, @RequestBody Product product) {

    return ResponseEntity.ok(this.iProdcutService.updateProduct(id, product));
  }

  @DeleteMapping(path = "/delete/{id}")
  public ResponseEntity<Boolean> productToDelete(@PathVariable Long id) {

    return ResponseEntity.ok(this.iProdcutService.deleteProduct(id));
  }

  
}
