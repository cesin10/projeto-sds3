package com.devsuperior.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	public List<SellerDTO> findAll(){
		List<Seller>result = sellerRepository.findAll();
//Usar a função map para converter uma coleção para uma nova coleção no caso vai ser  do tipo DTO 
// Depois converte a stream do tipo DTO para Lista com o collect(Collectors.toList()		
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
		
	}

}