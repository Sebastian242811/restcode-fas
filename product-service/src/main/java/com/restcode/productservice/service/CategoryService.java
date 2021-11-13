package com.restcode.productservice.service;


import com.restcode.productservice.client.RestaurantClient;
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
    private final RestaurantClient restaurantClient;

    public Category createCategory(Category category, Long restaurantId) {
        category.setEnabled(true);
        category.setRestaurant(restaurantClient.getOne(restaurantId));
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
