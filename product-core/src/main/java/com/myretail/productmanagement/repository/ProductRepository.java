package com.myretail.productmanagement.repository;

import com.myretail.productmanagement.common.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

  @Query("{'productId' : ?0}")
  Optional<Product> findByProductId(String productId);

}
