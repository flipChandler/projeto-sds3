package com.felipesantos.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipesantos.dsvendas.dto.SaleDTO;
import com.felipesantos.dsvendas.dto.SaleSuccessDTO;
import com.felipesantos.dsvendas.dto.SaleSumDTO;
import com.felipesantos.dsvendas.services.SaleService;

@RestController
@RequestMapping("/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
		
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
		Page<SaleDTO> sales = service.findAll(pageable);
		return ResponseEntity.ok(sales);
	}
	
	@GetMapping("/nopagination")
	public ResponseEntity<List<SaleDTO>> findAll() {
		List<SaleDTO> sales = service.findAll();
		return ResponseEntity.ok(sales);
	}
	
	@GetMapping("/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
		List<SaleSumDTO> sales = service.amountGroupedBySeller();
		return ResponseEntity.ok(sales);
	}
	
	@GetMapping("/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller() {
		List<SaleSuccessDTO> sales = service.successGroupedBySeller();
		return ResponseEntity.ok(sales);
	}
}
