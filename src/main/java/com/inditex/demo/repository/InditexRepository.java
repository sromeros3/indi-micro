package com.inditex.demo.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inditex.demo.model.repository.entities.ProductEntity;

public interface InditexRepository extends JpaRepository<ProductEntity, Long>{

	@Query(value = "SELECT * FROM PRICES WHERE PRODUCT_ID = :productId"
            + " AND BRAND_ID = :chainId"
            + " AND :applicationDate BETWEEN START_DATE AND END_DATE", nativeQuery = true)
    List<ProductEntity> findProducts(
            @Param("productId") Long productId, 
            @Param("chainId") Long chainId, 
            @Param("applicationDate") LocalDateTime applicationDate);

}
