package com.inditex.demo.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.demo.exceptions.InditexException;
import com.inditex.demo.model.controller.dto.ProductDetails;
import com.inditex.demo.service.InditexService;

@RestController
@RequestMapping("/inditex")
public class InditexController {
	    
	@Autowired
	@Qualifier("inditexService")
    InditexService inditexService;
	
    @GetMapping("/precio")
    public ResponseEntity<ProductDetails> getProductPrice(
            @RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha,
            @RequestParam("productoId") Long productoId,
            @RequestParam("cadenaId") Long cadenaId) {
    	ProductDetails productDetails = new ProductDetails();
    	try {
    		productDetails = inditexService.getProductDetails(fecha, productoId, cadenaId);

            return ResponseEntity.ok(productDetails);
    	} catch (InditexException e) {
    		return ResponseEntity.ok(productDetails);
    	}
    	
    }
}
