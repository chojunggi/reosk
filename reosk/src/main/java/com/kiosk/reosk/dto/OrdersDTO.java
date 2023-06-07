package com.kiosk.reosk.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class OrdersDTO {

    private Long orderNumber;
    private LocalDateTime orderDate;
    private List<OrdersDetailDTO> orderDetails;


}
