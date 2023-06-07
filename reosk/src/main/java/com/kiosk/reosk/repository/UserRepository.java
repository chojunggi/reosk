package com.kiosk.reosk.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiosk.reosk.entity.User;


public interface UserRepository extends JpaRepository<User, String> {
//	Optional<User>  findAllByPonNum(String ponNum);
	Optional<User> findByPonNum(String ponNum);
}
 