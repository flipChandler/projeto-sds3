package com.felipesantos.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felipesantos.dsvendas.dto.SaleDTO;
import com.felipesantos.dsvendas.dto.SaleSuccessDTO;
import com.felipesantos.dsvendas.dto.SaleSumDTO;
import com.felipesantos.dsvendas.entities.Sale;
import com.felipesantos.dsvendas.repositories.SaleRepository;
import com.felipesantos.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	public List<SaleDTO> findAll() {
		List<Sale> sales = repository.findAll();
		return sales.stream()
				.map(sale -> new SaleDTO(sale))
				.collect(Collectors.toList());
	}
	
	// Transactional + sellerRepository.findAll(), busca 1 vez somente todos os sellers, sem repetições
	@Transactional(readOnly = true)  
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> sales = repository.findAll(pageable);
		return sales.map(sale -> new SaleDTO(sale));
				
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller() {
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller() {
		return repository.successGroupedBySeller();
	}
	
}
