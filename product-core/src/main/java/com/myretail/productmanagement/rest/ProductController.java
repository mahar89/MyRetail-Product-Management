package com.myretail.productmanagement.rest;

import com.myretail.productmanagement.dto.ProductDto;
import com.myretail.productmanagement.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/products")
public class ProductController {

  private final ProductService productService;

  @GetMapping(path = "/{productId}")
  public ResponseEntity<ProductDto> getAccount (@PathVariable final String productId) {
    return ResponseEntity.ok(productService.getProduct(productId));
  }
}
