package com.teresa.ubicua.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "tlb_orders",
        schema = "ubicua_db",
        uniqueConstraints = @UniqueConstraint(
                name = "unique_otk",
                columnNames = "OrderTrackingNumber"
        )
)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "OrderTrackingNumber", nullable = false)
    private String OrderTrackingNumber;
    private int TotalQuantity;
    private BigDecimal totalPrice;
    private String status;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @CreationTimestamp
    private LocalDateTime lastUpdated;

    @OneToOne (cascade = CascadeType.ALL, mappedBy = "order")//si elimino un pedido, elimino todo
    //@JoinColumn(name = "billing_address_id", referencedColumnName = "id")
    private Address billingAddress;
}
