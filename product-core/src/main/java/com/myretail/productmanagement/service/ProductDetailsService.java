package com.myretail.productmanagement.service;

import com.myretail.productmanagement.common.entities.Price;
import com.myretail.productmanagement.common.entities.Product;
import com.myretail.productmanagement.dto.entities.ProductDetailsParent;
import com.myretail.productmanagement.repository.ProductRepository;
import com.myretail.productmanagement.util.ProductManagementUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductDetailsService {

  private final ProductRepository productRepository;

  private final RestTemplate restTemplate;

  Optional<Product> fetchAndSaveProduct(Integer productId, @Nullable Price price) {
    log.info("Fetching details for ProductId[{}]", productId);

    try {
      if (null == price) {
        final String priceDetailsUri = ProductManagementUtil.getPriceDetailsFetchUri(productId);
        price = restTemplate.getForObject(priceDetailsUri, Price.class);

        Objects.requireNonNull(price);
      }

      final String productDetailsUri = ProductManagementUtil.getProductDetailsFetchUri(productId);

      ProductDetailsParent productDetails = restTemplate.getForObject(productDetailsUri, ProductDetailsParent.class);

      Objects.requireNonNull(productDetails);

      final Product product = Product.builder()
          .productId(productId)
          .name(productDetails.getProductDetails().getProductItem().getProductDescription().getName())
          .price(price)
          .build();

      return Optional.of(productRepository.save(product));

    } catch (NullPointerException e) {
      log.error("No details found for ProductId[{}]", productId);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }

    return Optional.empty();
  }
}
