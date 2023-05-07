package com.inditex.demo;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.inditex.demo.controller.InditexController;
import com.inditex.demo.model.controller.dto.ProductDetails;
@SpringBootTest
class InditexMicroserviceApplicationTests {

	@Autowired
	InditexController controller;
	ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
	private final long product = 35455;
	private final long chain = 1;
	private final LocalDateTime fechaTest1 = LocalDateTime.of(2020, 6, 14, 10, 0, 0);
	private final LocalDateTime fechaTest2 = LocalDateTime.of(2020, 6, 14, 16, 0, 0);
	private final LocalDateTime fechaTest3 = LocalDateTime.of(2020, 6, 14, 21, 0, 0);
	private final LocalDateTime fechaTest4 = LocalDateTime.of(2020, 6, 15, 10, 0, 0);
	private final LocalDateTime fechaTest5 = LocalDateTime.of(2020, 6, 16, 21, 0, 0);
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void test1() throws StreamReadException, DatabindException, IOException  {
		
		File file = new File(this.getClass().getClassLoader()
			.getResource("data/test1.json").getFile());
		ProductDetails testResponse = mapper.readValue(file, ProductDetails.class);

		ResponseEntity<ProductDetails> responseController = controller.getProductPrice(fechaTest1, product, chain);
		
		Assert.assertTrue(EqualsBuilder.reflectionEquals(testResponse, responseController.getBody()));
	}
	
	@Test
	void test2() throws StreamReadException, DatabindException, IOException {
		File file = new File(this.getClass().getClassLoader()
			.getResource("data/test2.json").getFile());
		ProductDetails testResponse = mapper.readValue(file, ProductDetails.class);

		ResponseEntity<ProductDetails> responseController = controller.getProductPrice(fechaTest2, product, chain);
			
		Assert.assertTrue(EqualsBuilder.reflectionEquals(testResponse, responseController.getBody()));
	}
	
	@Test
	void test3() throws StreamReadException, DatabindException, IOException {
		File file = new File(this.getClass().getClassLoader()
			.getResource("data/test3.json").getFile());
		ProductDetails testResponse = mapper.readValue(file, ProductDetails.class);

		ResponseEntity<ProductDetails> responseController = controller.getProductPrice(fechaTest3, product, chain);
		
		Assert.assertTrue(EqualsBuilder.reflectionEquals(testResponse, responseController.getBody()));
	}
	
	@Test
	void test4() throws StreamReadException, DatabindException, IOException {
		File file = new File(this.getClass().getClassLoader()
			.getResource("data/test4.json").getFile());
		ProductDetails testResponse = mapper.readValue(file, ProductDetails.class);

		ResponseEntity<ProductDetails> responseController = controller.getProductPrice(fechaTest4, product, chain);
		
		Assert.assertTrue(EqualsBuilder.reflectionEquals(testResponse, responseController.getBody()));
	}

	@Test
	void test5() throws StreamReadException, DatabindException, IOException {
		File file = new File(this.getClass().getClassLoader()
			.getResource("data/test5.json").getFile());
		ProductDetails testResponse = mapper.readValue(file, ProductDetails.class);

		ResponseEntity<ProductDetails> responseController = controller.getProductPrice(fechaTest5, product, chain);
		
		Assert.assertTrue(EqualsBuilder.reflectionEquals(testResponse, responseController.getBody()));
	}
}
