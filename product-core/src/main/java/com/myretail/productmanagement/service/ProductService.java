package com.myretail.productmanagement.service;

import com.myretail.productmanagement.dto.ProductDto;
import com.myretail.productmanagement.mapper.ProductDtoMapper;
import com.myretail.productmanagement.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductService {

  private final ProductDetailsService productDetailsService;

  private final ProductDtoMapper productDtoMapper;

  private final ProductRepository productRepository;

  public ProductDto getProduct(String productId) {
    log.info("Retrieving product for id : {} ", productId);

    final ProductDto productDto = productRepository
        .findByProductId(productId)
        .map(productDtoMapper::productToProductDto)
        .orElseGet(() -> productDetailsService.fetchAndSaveProduct(productId)
            .map(productDtoMapper::productToProductDto)
            .orElseThrow(() ->
                new NoSuchElementException(
                    format("Product for id %s doesn't exist.", productId)))
        );

    log.info("Sending {} product", productDto);

    return productDto;
  }
}
