package com.restcode.productservice.controller;

import com.restcode.productservice.domain.model.Category;
import com.restcode.productservice.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/v2/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping()
    public Category create(@RequestBody() Category category) {
        return categoryService.createCategory(category);
    }

    @GetMapping()
    public List<Category> getAll() {
        return categoryService.getAllCategories();
    }

    @GetMapping("{id}")
    public Category getOne(@PathVariable(name = "id") Long id) {
        return categoryService.getCategory(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOne(@PathVariable(name = "id") Long id) {
        return categoryService.deleteCategory(id);
    }
}