package com.restcode.productservice.service;


import com.restcode.productservice.domain.model.Category;
import com.restcode.productservice.domain.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        category.setEnabled(true);
        return categoryRepository.save(category);
    }

    public Category updateCategory(Category category) {
        Category existingCry = getCategory(category.getId());
        existingCry.setName(category.getName());
        return categoryRepository.save(existingCry);
    }

    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public ResponseEntity<?> deleteCategory(Long id){
        Category category = getCategory(id);
        categoryRepository.delete(category);
        return ResponseEntity.ok().build();
    }
}
