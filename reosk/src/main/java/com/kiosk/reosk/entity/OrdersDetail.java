package com.kiosk.reosk.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oNum")
    private Orders orders;

    @ManyToOne
    private Product product;

    private int stock;
    private long totalPrice;
    private long allTotal;
    private long oPrice;
}
