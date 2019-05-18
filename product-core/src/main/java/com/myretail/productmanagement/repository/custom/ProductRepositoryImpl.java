package com.myretail.productmanagement.repository.custom;

import com.myretail.productmanagement.common.entities.Price;
import com.myretail.productmanagement.common.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import static com.myretail.productmanagement.util.ProductManagementUtil.PRODUCT_ID;
import static com.myretail.productmanagement.util.ProductManagementUtil.PRODUCT_PRICE;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepositoryCustom {

  private final MongoTemplate mongoTemplate;

  private static final FindAndModifyOptions FIND_AND_MODIFY_OPTIONS =
      new FindAndModifyOptions().upsert(false).returnNew(true);

  @Override
  public Product upsert(Product product) {

    String productId = product.getProductId();
    Price price = product.getPrice();

    Query query = new Query().addCriteria(Criteria.where(PRODUCT_ID).is(productId));

    Update update = new Update();
    update.set(PRODUCT_PRICE, price);

    return mongoTemplate.findAndModify(
        query, update, FIND_AND_MODIFY_OPTIONS, Product.class);

  }
}
