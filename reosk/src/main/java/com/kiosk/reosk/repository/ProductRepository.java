package com.kiosk.reosk.repository;

import com.kiosk.reosk.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findBypName(String pName);
}
