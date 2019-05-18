package com.myretail.productmanagement.service;

import com.myretail.productmanagement.common.entities.Price;
import com.myretail.productmanagement.common.entities.Product;
import com.myretail.productmanagement.dto.entities.ProductDetailsParent;
import com.myretail.productmanagement.repository.ProductRepository;
import com.myretail.productmanagement.util.ProductManagementUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductDetailsService {

  private final ProductRepository productRepository;

  private final ProductPriceService productPriceService;

  private final RestTemplate restTemplate;

  Optional<Product> fetchAndSaveProduct(String productId) {
    log.info("Fetching details for ProductID[{}]", productId);

    try {
      final String productDetailsUri = ProductManagementUtil.getProductDetailsFetchUri(productId);
      final String priceDetailsUri = ProductManagementUtil.getPriceDetailsFetchUri(productId);

      ProductDetailsParent productDetails = restTemplate.getForObject(productDetailsUri, ProductDetailsParent.class);

      Price price = restTemplate.getForObject(priceDetailsUri, Price.class);

      final Product product = Product.builder()
          .productId(productId)
          .name(productDetails.getProductDetails().getProductItem().getProductDescription().getName())
          .price(price)
          .build();

      return Optional.of(productRepository.save(product));

    } catch (Exception e) {
      log.error("No details found for ProductID[{}]", productId);

      return Optional.empty();
    }
  }
}
