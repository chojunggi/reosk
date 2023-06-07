package com.kiosk.reosk.service;

import com.kiosk.reosk.dto.OrdersDTO;
import com.kiosk.reosk.dto.OrdersDetailDTO;
import com.kiosk.reosk.entity.Orders;
import com.kiosk.reosk.entity.OrdersDetail;
import com.kiosk.reosk.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
public interface ReoskService {

    List<OrdersDetailDTO> getOrdersDetailByOnum(Long onum);

    void saveOrder(String body, HttpSession session) throws Exception;
}
