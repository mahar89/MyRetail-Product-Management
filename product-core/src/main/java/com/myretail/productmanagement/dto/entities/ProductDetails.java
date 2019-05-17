package com.myretail.productmanagement.dto.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDetails {

  @JsonProperty("item")
  private ProductItem productItem;
}
