package com.kiosk.reosk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiosk.reosk.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, String> {

}
