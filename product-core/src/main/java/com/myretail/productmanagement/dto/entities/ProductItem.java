package com.myretail.productmanagement.dto.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductItem {

  @JsonProperty("product_description")
  private ProductDescription productDescription;
}
