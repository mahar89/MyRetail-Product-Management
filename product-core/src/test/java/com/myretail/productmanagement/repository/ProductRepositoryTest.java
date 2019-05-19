package com.myretail.productmanagement.repository;

import com.myretail.productmanagement.common.entities.Product;
import com.myretail.productmanagement.repository.custom.ProductRepositoryImpl;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import static com.myretail.productmanagement.util.ProjectManagementTestUtil.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductRepositoryTest {

  @Mock
  private MongoTemplate mongoTemplate;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @InjectMocks
  private ProductRepositoryImpl productRepository;

  @Test
  public void Given_a_stored_product_for_price_update_When_upsert_method_invoked_Then_its_updated_successfully() {
    when(mongoTemplate.findAndModify(any(Query.class), any(Update.class), any(FindAndModifyOptions.class), eq(Product.class)))
        .thenReturn((updatedProductStub()));

    Product updatedProduct = productRepository.upsert(updatedProductStub()).get();

    ArgumentCaptor<Update> updateArgumentCaptor = ArgumentCaptor.forClass(Update.class);
    ArgumentCaptor<Query> queryArgumentCaptor = ArgumentCaptor.forClass(Query.class);

    verify(mongoTemplate).findAndModify(queryArgumentCaptor.capture(), updateArgumentCaptor.capture(), any(FindAndModifyOptions.class), eq(Product.class));

    Assert.assertEquals(criteriaKeyValueMapForPriceUpdation(), queryArgumentCaptor.getValue().getQueryObject());
    Assert.assertEquals(expectedUpdateObjectDocumentFields(), updateArgumentCaptor.getValue().getUpdateObject().get(SET));
    Assert.assertEquals(updatedProductStub(), updatedProduct);
  }
}