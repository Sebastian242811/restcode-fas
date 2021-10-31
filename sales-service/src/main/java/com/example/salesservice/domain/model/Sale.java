package com.example.salesservice.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties(value = {"id"}, allowGetters = true)
public class Sale extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String currency;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sale")
    private List<SaleItem> items;
}
