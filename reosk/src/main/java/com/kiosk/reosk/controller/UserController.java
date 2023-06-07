package com.kiosk.reosk.controller;

import com.kiosk.reosk.entity.User;
import com.kiosk.reosk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class UserController {
    
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    @GetMapping("/user2")
//    public String getUserByPonNum(@PathVariable String ponNum,Model model) {
//        User nickName=userRepository.findAllByPonNum(ponNum);
//        
//        return nickName;
//    }
//    @GetMapping("/user")
//    public String a() {
//		return "/reosk/user";
//    	
//    }
}
