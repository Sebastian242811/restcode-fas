package com.example.salesservice.domain.repository;

import com.example.salesservice.domain.model.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {
}
