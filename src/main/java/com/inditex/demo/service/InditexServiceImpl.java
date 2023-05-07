package com.inditex.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.inditex.demo.exceptions.InditexException;
import com.inditex.demo.model.controller.dto.ProductDetails;
import com.inditex.demo.model.mapper.InditexMapper;
import com.inditex.demo.model.repository.entities.ProductEntity;
import com.inditex.demo.repository.InditexRepository;

@Service
@Qualifier("inditexService")
public class InditexServiceImpl implements InditexService{

	@Autowired
    @Qualifier("inditexRepository")
    private InditexRepository inditexRepository;
	
	@Autowired
    private InditexMapper inditexMapper;
	
	@Override
	public ProductDetails getProductDetails(LocalDateTime fecha, Long productoId, Long cadenaId) {
		
		List<ProductEntity> candidates = checkProductDates(productoId, fecha, cadenaId);
		
		if (!candidates.isEmpty()) {
			Optional<ProductEntity> bestCandidate = checkPriority(candidates);
			return inditexMapper.productEntityToProductDetail(bestCandidate.get());
		} else {
			throw new InditexException("Ningun elemento", HttpStatus.OK);
		}
	}

	private List<ProductEntity> checkProductDates(Long productoId, LocalDateTime fecha, Long cadenaId) {
		
		List<ProductEntity> queryResult = inditexRepository.findProducts(productoId, cadenaId, fecha);
		
		return queryResult;
	}
	

	private Optional<ProductEntity> checkPriority(List<ProductEntity> candidateList) {
		
		return candidateList.stream()
			.reduce((producto1, producto2) -> 
				producto1.getPriority() > producto2.getPriority() ? producto1 : producto2);
	}
}
