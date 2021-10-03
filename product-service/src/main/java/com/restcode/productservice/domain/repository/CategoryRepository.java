package com.restcode.productservice.domain.repository;

import com.restcode.productservice.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
