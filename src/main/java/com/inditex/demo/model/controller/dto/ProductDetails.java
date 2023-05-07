package com.inditex.demo.model.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDetails {
	
	public Long productId;
	public Integer chainId;
	public Integer priceList;
	public LocalDateTime startDate;
	public LocalDateTime endDate;
	public BigDecimal price;

}
