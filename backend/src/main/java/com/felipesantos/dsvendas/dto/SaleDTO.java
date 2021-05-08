package com.felipesantos.dsvendas.dto;

import java.time.LocalDate;

import com.felipesantos.dsvendas.entities.Sale;

public class SaleDTO {
	
	private Long id;
	private Integer visited;
	private Integer deals;
	private Double amount;
	private LocalDate date;
	
	private SellerDTO seller;
	
	public SaleDTO() {
		
	}
	
	

	public SaleDTO(Long id, Integer visited, Integer deals, Double amount, LocalDate date, SellerDTO seller) {
		setId(id);
		setVisited(visited);
		setDeals(deals);
		setAmount(amount);
		setDate(date);
		setSeller(seller);
	}
	
	public SaleDTO(Sale entity) {
		setId(entity.getId());
		setVisited(entity.getVisited());
		setDeals(entity.getDeals());
		setAmount(entity.getAmount());
		setDate(entity.getDate());
		setSeller(new SellerDTO(entity.getSeller()));
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVisited() {
		return visited;
	}

	public void setVisited(Integer visited) {
		this.visited = visited;
	}

	public Integer getDeals() {
		return deals;
	}

	public void setDeals(Integer deals) {
		this.deals = deals;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public SellerDTO getSeller() {
		return seller;
	}

	public void setSeller(SellerDTO seller) {
		this.seller = seller;
	}
	
	
	
}
