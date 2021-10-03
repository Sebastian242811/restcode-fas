package com.example.salesservice.domain.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne()
    private Sale sale;
}
