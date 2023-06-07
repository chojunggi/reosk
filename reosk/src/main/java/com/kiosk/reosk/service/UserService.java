package com.kiosk.reosk.service;



import com.kiosk.reosk.entity.User;
import com.kiosk.reosk.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public Optional<User> findUsersByPonNum(String ponNum) { 
    	System.out.println("pon번호 : " + ponNum);
    	Optional<User> memberOptional =userRepository.findAllByPonNum(ponNum);
    	
    	System.out.println("***********" + memberOptional.toString());
    	if (memberOptional.isPresent()) {
    		return memberOptional;
    	}else {
    		User member = memberOptional.orElse(new User("1", null, null, null, null));
    		
    		return Optional.of(member);
    	}
    }

}

