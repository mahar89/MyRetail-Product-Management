package com.myretail.productmanagement.service;

import com.myretail.productmanagement.common.entities.Price;
import com.myretail.productmanagement.common.entities.Product;
import com.myretail.productmanagement.dto.ProductDto;
import com.myretail.productmanagement.mapper.ProductDtoMapper;
import com.myretail.productmanagement.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.NoSuchElementException;
import java.util.Optional;

import static com.myretail.productmanagement.util.ProductManagementUtil.getExceptionMessageIfProductNotExists;
import static com.myretail.productmanagement.util.ProjectManagementTestUtil.*;
import static org.mockito.Matchers.any;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

  @Mock
  private ProductDtoMapper productDtoMapper;

  @Mock
  private ProductRepository productRepository;

  @Mock
  private ProductDetailsService productDetailsService;

  @InjectMocks
  private ProductService productService;

  @Test
  public void GIVEN_an_productId_and_stored_product_WHEN_getProduct_invoked_THEN_returns_stored_product() {

    when(productRepository.findByProductId(any(String.class))).thenReturn(Optional.of(createProductStub()));
    when(productDtoMapper.productToProductDto(any(Product.class))).thenReturn(createProductDtoStub());

    ProductDto outputProductDto = productService.getProduct(PRODUCT_ID);
    verify(productRepository).findByProductId(any(String.class));
    verify(productDetailsService, times(0)).fetchAndSaveProduct(any(String.class), any(Price.class));
    verify(productDtoMapper).productToProductDto(any(Product.class));

    assertEquals(createProductDtoStub(), outputProductDto);
  }

  @Test
  public void GIVEN_an_productId_and_unstored_product_WHEN_getProduct_invoked_THEN_returns_newly_stored_product() {

    when(productRepository.findByProductId(any(String.class))).thenReturn(Optional.empty());
    when(productDetailsService.fetchAndSaveProduct(any(String.class), any(Price.class))).thenReturn(Optional.of(createProductStub()));
    when(productDtoMapper.productToProductDto(any(Product.class))).thenReturn(createProductDtoStub());

    ProductDto outputProductDto = productService.getProduct(PRODUCT_ID);
    verify(productRepository).findByProductId(any(String.class));
    verify(productDetailsService).fetchAndSaveProduct(any(String.class), any(Price.class));
    verify(productDtoMapper).productToProductDto(any(Product.class));

    assertEquals(createProductDtoStub(), outputProductDto);
  }

  @Test
  public void GIVEN_an_productId_WHEN_product_does_not_exist_THEN_getProduct_throws_NoSuchElement_exception() {

    final String exceptionMessage = getExceptionMessageIfProductNotExists(NOT_EXISTING_PRODUCT_ID);

    when(productRepository.findByProductId(any(String.class))).thenReturn(Optional.empty());
    when(productDetailsService.fetchAndSaveProduct(any(String.class), any(Price.class))).thenReturn(Optional.empty());

    try {
      productService.getProduct(NOT_EXISTING_PRODUCT_ID);
    } catch (NoSuchElementException exception) {
      assertEquals(exceptionMessage, exception.getMessage());
    }

    verify(productDtoMapper, times(0)).productToProductDto(any(Product.class));
  }

  @Test
  public void GIVEN_a_price_update_request_WHEN_updateProduct_invoked_THEN_returns_updated_productDto() {

    when(productRepository.upsert(any(Product.class))).thenReturn(Optional.of(updatedProductStub()));
    when(productDtoMapper.productToProductDto(any(Product.class))).thenReturn(updatedProductDtoStub());

    ProductDto outputProductDto = productService.updateProduct(updatedProductDtoStub());
    verify(productRepository).upsert(any(Product.class));
    verify(productDetailsService, times(0)).fetchAndSaveProduct(any(String.class), any(Price.class));
    verify(productDtoMapper).productToProductDto(any(Product.class));

    assertEquals(updatedProductDtoStub(), outputProductDto);
  }

  @Test
  public void GIVEN_a_price_update_request_and_unstored_product_WHEN_updateProduct_invoked_THEN_returns_productDto() {
    when(productDetailsService.fetchAndSaveProduct(any(String.class), any(Price.class))).thenReturn(Optional.of(updatedProductStub()));
    when(productRepository.upsert(any(Product.class))).thenReturn(Optional.empty());
    when(productDtoMapper.productToProductDto(any(Product.class))).thenReturn(updatedProductDtoStub());

    ProductDto outputProductDto = productService.updateProduct(updatedProductDtoStub());
    verify(productRepository).upsert(any(Product.class));
    verify(productDetailsService).fetchAndSaveProduct(any(String.class), any(Price.class));
    verify(productDtoMapper).productToProductDto(any(Product.class));

    assertEquals(updatedProductDtoStub(), outputProductDto);
  }

  @Test
  public void GIVEN_a_price_update_request_WHEN_product_does_not_exist_THEN_updateProduct_throws_NoSuchElement_exception() {

    final String exceptionMessage = getExceptionMessageIfProductNotExists(NOT_EXISTING_PRODUCT_ID);

    when(productRepository.upsert(any(Product.class))).thenReturn(Optional.empty());
    when(productDetailsService.fetchAndSaveProduct(any(String.class), any(Price.class))).thenReturn(Optional.empty());

    try {
      productService.updateProduct(notExistingProductDtoStub());
    } catch (NoSuchElementException exception) {
      assertEquals(exceptionMessage, exception.getMessage());
    }

    verify(productDtoMapper, times(0)).productToProductDto(any(Product.class));
  }
}