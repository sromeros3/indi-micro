package com.inditex.demo.service;

import java.time.LocalDateTime;

import com.inditex.demo.model.controller.dto.ProductDetails;


public interface InditexService {

	public ProductDetails getProductDetails(LocalDateTime fecha, Long productoId, Long cadenaId);

}
