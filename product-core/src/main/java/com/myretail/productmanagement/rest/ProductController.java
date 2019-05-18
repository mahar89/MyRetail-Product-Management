package com.myretail.productmanagement.rest;

import com.myretail.productmanagement.dto.ProductDto;
import com.myretail.productmanagement.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/products")
public class ProductController {

  private final ProductService productService;

  @GetMapping(path = "/{productId}")
  public ResponseEntity<ProductDto> getProduct(@PathVariable final String productId) {
    return ResponseEntity.ok(productService.getProduct(productId));
  }

  @PatchMapping(path = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> patchProduct(@PathVariable final String productId,
                                        @Valid @RequestBody final ProductDto productDto) {
    return ResponseEntity.ok(productService.patchProduct(productDto));
  }
}
