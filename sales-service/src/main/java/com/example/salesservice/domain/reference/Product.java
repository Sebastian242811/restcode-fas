package com.example.salesservice.domain.reference;

import lombok.Data;

@Data
public class Product {
    private Long id;

    private boolean enabled;

    private String name;

    private Double price;

    private String description;
}
