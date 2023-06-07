package com.kiosk.reosk.service;

import com.kiosk.reosk.dto.OrdersDTO;
import com.kiosk.reosk.dto.OrdersDetailDTO;
import com.kiosk.reosk.entity.Orders;
import com.kiosk.reosk.entity.OrdersDetail;
import com.kiosk.reosk.entity.Product;
import com.kiosk.reosk.repository.OrdersDetailRepository;
import com.kiosk.reosk.repository.OrdersRepository;
import com.kiosk.reosk.repository.ProductRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReoskServiceImpl implements ReoskService {

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    OrdersDetailRepository ordersDetailRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<OrdersDetailDTO> getOrdersDetailByOnum(Long onum) {
        Orders orders = ordersRepository.findByoNum(onum);
        List<OrdersDetailDTO> results = new ArrayList<OrdersDetailDTO>();
        if (orders == null) {
            return null;
        }
        List<OrdersDetail> orderDetails = orders.getOrdersDetailByoNum(onum);
        System.out.println("service ====" + orderDetails.size());
        for (OrdersDetail ord : orderDetails) {
            OrdersDetailDTO dto = OrdersDetailDTO.builder()
                    .onum(ord.getOrders().getONum())
                    .productPrice(ord.getOPrice())
                    .stock(ord.getStock())
                    .totalPrice(ord.getTotalPrice())
                    .productName(ord.getProduct().getPName())
                    .build();
            results.add(dto);
        }
        return results;
    }

    @Override
    public void saveOrder(String body, HttpSession session) throws Exception {
        List<OrdersDetailDTO> results = new ArrayList<>();

        JSONParser parser = new JSONParser();

        JSONArray obj = (JSONArray) parser.parse(body);

        System.out.println("받아온거 ===="+obj.toJSONString());

        for (int i = 0; i < obj.size();i++) {

            JSONObject obj1 = (JSONObject) obj.get(i);
            
            String name = (String) obj1.get("name");
            
            Long price = Long.parseLong((String) obj1.get("price"));
            
            Long quantity = (Long) obj1.get("quantity");

            OrdersDetailDTO dto = OrdersDetailDTO.builder().productName(name).productPrice(price).stock(Integer.parseInt(String.valueOf(quantity))).build();

            results.add(dto);
        }

        Orders orders = Orders.builder().build();
        List<OrdersDetail> ordersDetails = new ArrayList<>();

        for (OrdersDetailDTO dto : results) {
            Product product = Product.builder().pName(dto.getProductName()).build();
            productRepository.save(product); // Product 엔티티를 저장합니다.
            OrdersDetail ordersDetail = OrdersDetail.builder()
                    .product(product)
                    .stock(dto.getStock())
                    .oPrice(dto.getProductPrice())
                    .totalPrice(dto.getProductPrice() * dto.getStock())
                    .build();
            ordersDetails.add(ordersDetail);
        }

        orders.setOrdersDetails(ordersDetails);
        ordersRepository.save(orders);

        session.setAttribute("onum", orders.getONum());
    }

}


