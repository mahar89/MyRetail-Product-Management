package com.myretail.productmanagement.util;

import com.myretail.productmanagement.common.entities.Price;
import com.myretail.productmanagement.common.entities.Product;
import com.myretail.productmanagement.dto.PriceDto;
import com.myretail.productmanagement.dto.ProductDto;
import org.bson.Document;
import wiremock.com.google.common.collect.ImmutableMap;

import java.util.Map;

public class ProjectManagementTestUtil {

  public static final Integer PRODUCT_ID = 3860428;
  public static final String PRODUCT_ID_KEY = "productId";
  public static final String PRICE_KEY = "price";
  public static final String SET = "$set";
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

  public static Map<String, Object> createProductDocumentStub() {
    return new ImmutableMap.Builder<String, Object>()
        .put(PRICE_KEY, createPriceDocumentStub())
        .build();
  }

  public static Price createPriceDocumentStub() {
    return Price.builder()
        .currency("USD")
        .value(92.0)
        .build();
  }

  public static Document expectedUpdateObjectDocumentFields() {
    Document document = new Document();
    document.put(PRICE_KEY, createPriceDocumentStub());
    return document;
  }

  public static  Map<String, ? extends Object> criteriaKeyValueMapForPriceUpdation() {
    return ImmutableMap.of(PRODUCT_ID_KEY, PRODUCT_ID);
  }

}
