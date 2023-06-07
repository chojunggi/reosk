package com.kiosk.reosk.entity;

import com.kiosk.reosk.dto.OrdersDetailDTO;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Orders  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oNum;

    @CreatedDate
    @Column(name = "oDate")
    private LocalDateTime oDate;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<OrdersDetail> ordersDetails;

    @PrePersist
    public void onPrePersist() {
        this.oDate = LocalDateTime.now();
    }

    public List<OrdersDetail> getOrdersDetailByoNum(Long onum) {
        List<OrdersDetail> results = new ArrayList<>();
        for (OrdersDetail ordersDetail : ordersDetails) {
            if (ordersDetail.getOrders().getONum().equals(onum)) {
                results.add(ordersDetail);
            }
        }
        return results.isEmpty() ? null : results;
    }

    public void setOrdersDetails(List<OrdersDetail> ordersDetails) {
        this.ordersDetails = ordersDetails;
        for (OrdersDetail detail : ordersDetails) {
            detail.setOrders(this);
        }
    }

}
