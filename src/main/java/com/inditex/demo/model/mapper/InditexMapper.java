package com.inditex.demo.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.demo.model.controller.dto.ProductDetails;
import com.inditex.demo.model.repository.entities.ProductEntity;

@Mapper(componentModel = "spring")
public interface InditexMapper {
	
	@Mapping(source = "brandId", target = "chainId")
	ProductDetails productEntityToProductDetail(ProductEntity priceObject);

}
