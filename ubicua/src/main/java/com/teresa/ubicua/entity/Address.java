package com.teresa.ubicua.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "tlb_addresses",
        schema = "ubicua_db"
)

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Street;
    private String City;
    private String State;
    private String Country;
    private String zipCode;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")//con quien voy a hacer join
    private Order order;
}
