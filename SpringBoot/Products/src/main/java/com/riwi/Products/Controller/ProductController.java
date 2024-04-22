package com.riwi.Products.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.Products.Entity.Product;
import com.riwi.Products.Service.service_abstract.IProdcutService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

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
  public ResponseEntity<Product> addProduct(@RequestBody Product product){


    return new ResponseEntity<>(this.iProdcutService.saveProduct(product),HttpStatus.CREATED);
  }

}
