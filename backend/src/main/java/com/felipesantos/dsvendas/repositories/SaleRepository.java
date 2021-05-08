package com.felipesantos.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.felipesantos.dsvendas.dto.SaleSuccessDTO;
import com.felipesantos.dsvendas.dto.SaleSumDTO;
import com.felipesantos.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	// select de novos objs de SaleSumDTO 
	@Query("SELECT new com.felipesantos.dsvendas.dto.SaleSumDTO(sale.seller, SUM(sale.amount)) "
			+ " FROM Sale AS sale GROUP BY sale.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.felipesantos.dsvendas.dto.SaleSuccessDTO(sale.seller, SUM(sale.visited), SUM(sale.deals)) "
			+ " FROM Sale AS sale GROUP BY sale.seller")
	List<SaleSuccessDTO> successGroupedBySeller();
}
 