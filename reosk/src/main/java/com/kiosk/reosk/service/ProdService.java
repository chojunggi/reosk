package com.kiosk.reosk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiosk.reosk.entity.Prod;
import com.kiosk.reosk.repository.ProdRepository;

@Service
public class ProdService {

	@Autowired
	ProdRepository prodRepository;
	
	public List<Prod> getAllProd(){
		return prodRepository.findAll();
	}
	
	public void SaveProd(Prod prod){
		prodRepository.save(prod);
	}
}
