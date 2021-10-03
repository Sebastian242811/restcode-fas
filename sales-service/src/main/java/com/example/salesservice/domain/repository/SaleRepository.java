package com.example.salesservice.domain.repository;

import com.example.salesservice.domain.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
