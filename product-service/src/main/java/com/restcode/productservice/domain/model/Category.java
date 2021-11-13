package com.restcode.productservice.domain.model;

import com.restcode.productservice.domain.reference.Restaurant;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean enabled;

    private String name;

    @Transient
    private Restaurant restaurant;
}
