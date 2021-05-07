package com.felipesantos.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipesantos.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

}
