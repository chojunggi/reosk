package com.kiosk.reosk.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrdersDetailDTO {

    private Long onum;
    private String productName;
    private Long orderCount;
    private long productPrice;
    private int stock;
    private Long totalPrice;
}
