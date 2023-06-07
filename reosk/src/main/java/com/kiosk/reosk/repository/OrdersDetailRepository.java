package com.kiosk.reosk.repository;

import com.kiosk.reosk.entity.OrdersDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDetailRepository extends JpaRepository<OrdersDetail, Long> {
}
