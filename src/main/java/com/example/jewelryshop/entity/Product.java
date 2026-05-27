package com.example.jewelryshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String brand;

    private String model;

    private String category;

    private BigDecimal price;

    private Integer stock;

    private String material;

    @Column(length = 1000)
    private String description;

    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}