package com.myretail.productmanagement.mapper;

import com.myretail.productmanagement.common.entities.Price;
import com.myretail.productmanagement.common.entities.Product;
import com.myretail.productmanagement.dto.PriceDto;
import com.myretail.productmanagement.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductDtoMapper {

  ProductDto productToProductDto(Product product);

  Product productDtoToProduct(ProductDto productDto);

  PriceDto priceToPriceDto(Price price);

  Price priceDtoToPrice(PriceDto priceDto);
}


