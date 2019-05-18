package com.myretail.productmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto {

  @JsonProperty("id")
  @NotBlank(message = "ProductID cannot be null or empty.")
  private String productId;

  private String name;

  @JsonProperty("current_price")
  @Valid
  private PriceDto price;
}
