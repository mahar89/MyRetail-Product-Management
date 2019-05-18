package com.myretail.productmanagement.util;

import com.myretail.productmanagement.common.entities.Price;
import com.myretail.productmanagement.common.entities.Product;
import com.myretail.productmanagement.dto.PriceDto;
import com.myretail.productmanagement.dto.ProductDto;

public class ProjectManagementTestUtil {

  public static final String PRODUCT_ID = "13860428";

  public static final String NOT_EXISTING_PRODUCT_ID = "NOMORE123";

  public static Product createProductStub() {
    return Product.builder()
        .name("The Big Lebowski (Blu-ray)")
        .id("13860428")
        .price(Price.builder().value(12.0).currency("USD").build())
        .build();
  }

  public static Product updatedProductStub() {
    return Product.builder()
        .name("The Big Lebowski (Blu-ray)")
        .id("13860428")
        .price(Price.builder().value(92.0).currency("USD").build())
        .build();
  }

  public static ProductDto createProductDtoStub() {
    return ProductDto.builder()
        .name("The Big Lebowski (Blu-ray)")
        .productId("13860428")
        .price(PriceDto.builder().value(12.0).currency("USD").build())
        .build();
  }

  public static ProductDto updatedProductDtoStub() {
    return ProductDto.builder()
        .name("The Big Lebowski (Blu-ray)")
        .productId("13860428")
        .price(PriceDto.builder().value(92.0).currency("USD").build())
        .build();
  }

  public static ProductDto notExistingProductDtoStub() {
    return ProductDto.builder()
        .name("Not")
        .productId("NOMORE123")
        .price(PriceDto.builder().value(92.0).currency("TT").build())
        .build();
  }

}
