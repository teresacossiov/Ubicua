package com.teresa.ubicua.entity;

import jakarta.persistence.*;

import javax.lang.model.element.Name;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(
        name = "tlb_products",
        schema = "ubicua_db",
        uniqueConstraints = @UniqueConstraint(
                name = "unique_sku",
                columnNames = "stock_keeping_unit"
        )
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "stock_keeping_unit", nullable = false)
    private String sku; //stock_keeping_unit

    private String Description;

    private BigDecimal Price;
    private boolean Active;
    private String urlImage;
    @CreationTimestamp //graba por defecto la fecha actual
    private LocalDateTime DateCreated;
    @UpdateTimestamp //graba la fecha de la ultima actualizacion
    private LocalDateTime DateUpdated;
}