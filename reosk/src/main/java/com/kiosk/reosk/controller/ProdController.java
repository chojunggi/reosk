package com.kiosk.reosk.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kiosk.reosk.entity.Prod;
import com.kiosk.reosk.entity.User;
import com.kiosk.reosk.repository.UserRepository;
import com.kiosk.reosk.service.ProdService;
import com.kiosk.reosk.service.UserService;

@RestController
@RequestMapping("/reosk")

public class ProdController {

	@Autowired
	ProdService prodService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/products")
	public List<Prod> getProd(){
		List<Prod> prod = prodService.getAllProd();
		return prod;
	}
	
	@PostMapping("/prodcr")
	public String addProdData(@RequestBody Prod formData) {
		
		System.out.println("transdata" + formData.toString());
    	
		prodService.SaveProd(formData);
		return "redirect:/reosk/product";
	}

	
	@PostMapping("/loginService")
    public Optional<User> findUsersByPonNum(String ponNum) { 
    	System.out.println("pon2번호 : " + ponNum);
  //  	Optional<User> memberOptional =userRepository.findAllByPonNum(ponNum);
    	Optional<User> memberOptional =userService.findUsersByPonNum(ponNum);
    	
    	return memberOptional;
    }

	
}
