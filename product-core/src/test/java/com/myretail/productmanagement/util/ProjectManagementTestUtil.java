package com.myretail.productmanagement.util;

import com.myretail.productmanagement.common.entities.Price;
import com.myretail.productmanagement.common.entities.Product;
import com.myretail.productmanagement.dto.PriceDto;
import com.myretail.productmanagement.dto.ProductDto;

public class ProjectManagementTestUtil {

  public static final Integer PRODUCT_ID = 3860428;

  public static final Integer NOT_EXISTING_PRODUCT_ID = 3123;


  public static String getExceptionMessageIfProductNotExists(Integer productId) {
    return String.format("Product with ID[%s] doesn't exist.", productId);
  }

  public static Product createProductStub() {
    return Product.builder()
        .name("The Big Lebowski (Blu-ray)")
        .productId(PRODUCT_ID)
        .price(Price.builder().value(12.0).currency("USD").build())
        .build();
  }

  public static Product updatedProductStub() {
    return Product.builder()
        .name("The Big Lebowski (Blu-ray)")
        .productId(PRODUCT_ID)
        .price(Price.builder().value(92.0).currency("USD").build())
        .build();
  }

  public static ProductDto createProductDtoStub() {
    return ProductDto.builder()
        .name("The Big Lebowski (Blu-ray)")
        .productId(PRODUCT_ID)
        .price(PriceDto.builder().value(12.0).currency("USD").build())
        .build();
  }

  public static ProductDto updatedProductDtoStub() {
    return ProductDto.builder()
        .name("The Big Lebowski (Blu-ray)")
        .productId(PRODUCT_ID)
        .price(PriceDto.builder().value(92.0).currency("USD").build())
        .build();
  }

  public static ProductDto notExistingProductDtoStub() {
    return ProductDto.builder()
        .name("Not")
        .productId(NOT_EXISTING_PRODUCT_ID)
        .price(PriceDto.builder().value(92.0).currency("TT").build())
        .build();
  }

}
