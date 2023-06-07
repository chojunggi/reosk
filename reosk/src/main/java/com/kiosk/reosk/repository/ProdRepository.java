package com.kiosk.reosk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiosk.reosk.entity.Menu;
import com.kiosk.reosk.entity.Prod;

public interface ProdRepository extends JpaRepository<Prod, String> {
	List<Prod> findByMenu(Menu menu);
}
