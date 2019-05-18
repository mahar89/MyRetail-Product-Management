package com.myretail.productmanagement.repository.custom;

import com.myretail.productmanagement.common.entities.Product;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface ProductRepositoryCustom {

  Optional<Product> upsert(Product product);
}
