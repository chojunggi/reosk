package com.kiosk.reosk.controller;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.kiosk.reosk.entity.User;
import com.kiosk.reosk.repository.UserRepository;
import com.kiosk.reosk.service.UserService;

@Controller
@RequestMapping("/reosk")
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;

	
    @GetMapping("/login")
    public String login() {
        return "reosk/Login";
    }
    @GetMapping("/signup")
    public String SignUp() {
    	
   
    	
        return "reosk/SignUp";
    }


    @PostMapping("/signupOK")
    public String signUp(@ModelAttribute User user , HttpSession session) {
    	System.out.println("들어옴"+user);
    //	session.setAttribute("nickname", user.getNickname());
        userService.saveUser(user);
        return "redirect:/reosk/login";
    }
    
    
//    @PostMapping("/loginService")
//    public Optional<User> findUsersByPonNum(String ponNum) { 
//    	System.out.println("pon2번호 : " + ponNum);
//    	Optional<User> memberOptional =userRepository.findAllByPonNum(ponNum);
//    	
//    	if (memberOptional.isPresent()) {
//    		return memberOptional;
//    	}else {
//    		User member = memberOptional.orElse(new User("1", ponNum, ponNum, ponNum, ponNum));
//    		
//    		return Optional.of(member);
//    	}
//    }

    

}
