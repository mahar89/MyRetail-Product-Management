package com.myretail.productmanagement.dto.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class ProductDetailsParent {

  @JsonProperty("product")
  private ProductDetails productDetails;

}
