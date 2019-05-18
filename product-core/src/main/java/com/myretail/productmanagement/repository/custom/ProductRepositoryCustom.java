package com.myretail.productmanagement.repository.custom;

import com.myretail.productmanagement.common.entities.Product;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ProductRepositoryCustom {

  Product upsert(Product product);
}
