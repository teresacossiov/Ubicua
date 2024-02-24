package com.teresa.ubicua.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String imgUrl;
    private BigDecimal price;
    private int quantity;

    //La relacion entre product y orderitem es 1:1
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
