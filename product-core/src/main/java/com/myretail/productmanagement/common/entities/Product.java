package com.myretail.productmanagement.common.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "Product")
public class Product {

  @Id
  private String id;

  @Indexed(unique = true)
  private Integer productId;

  private String name;

  private Price price;

}
