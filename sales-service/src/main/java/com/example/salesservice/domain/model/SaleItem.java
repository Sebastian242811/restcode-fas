package com.example.salesservice.domain.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class SaleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double price;

    private String name;

    private Boolean onSale;

    private Integer quantity;

    @ManyToOne()
    private Sale sale;
}
