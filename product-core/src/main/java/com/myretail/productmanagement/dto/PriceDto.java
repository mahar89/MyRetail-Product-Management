package com.myretail.productmanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceDto {

  @NotNull(message = "Price value cannot be null.")
  private Double value;

  @NotBlank(message = "Currency code cannot be null or empty.")
  @JsonProperty("currency_code")
  private String currency;
}
