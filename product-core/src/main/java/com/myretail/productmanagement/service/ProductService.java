package com.myretail.productmanagement.service;

import com.myretail.productmanagement.common.entities.Product;
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
    log.info("Retrieving product with ID[{}] ", productId);

    final ProductDto productDto = productRepository
        .findByProductId(productId)
        .map(productDtoMapper::productToProductDto)
        .orElseGet(() -> productDetailsService.fetchAndSaveProduct(productId, null)
            .map(productDtoMapper::productToProductDto)
            .orElseThrow(() ->
                new NoSuchElementException(
                    format("Product with ID[%s] doesn't exist.", productId)))
        );

    log.info("Sending {} product.", productDto);

    return productDto;
  }

  public ProductDto updateProduct(ProductDto productDto) {
    String productId = productDto.getProductId();
    log.info("Updating the product with ID[{}] ", productId);

    final ProductDto updatedProductDto = productRepository
        .upsert(productDtoMapper.productDtoToProduct(productDto))
        .map(productDtoMapper::productToProductDto)
        .orElseGet(() -> productDetailsService.fetchAndSaveProduct(productId, productDtoMapper.priceDtoToPrice(productDto.getPrice()))
            .map(productDtoMapper::productToProductDto)
            .orElseThrow(() ->
                new NoSuchElementException(
                    format("Product with ID[%s] doesn't exist.", productId)))
        );


    log.info("Product with ID[{}] updated successfully.", updatedProductDto.getProductId());
    return updatedProductDto;
  }
}
