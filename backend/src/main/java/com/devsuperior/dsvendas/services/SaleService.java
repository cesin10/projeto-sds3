package com.devsuperior.dsvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){

//Armazena os vendedores na memória para não buscar várias vezes no banco,
//isso funciona para poucos vendedores para muitos vendedores não.
		sellerRepository.findAll(); 
		
		Page<Sale>result = saleRepository.findAll(pageable);
//Usar a função map para converter uma coleção para uma nova coleção no caso vai ser  do tipo DTO 
// Depois converte a stream do tipo DTO para Lista com o collect(Collectors.toList()		
		return result.map(x -> new SaleDTO(x));
		
	}

}