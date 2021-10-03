package com.restcode.productservice.controller;


import com.restcode.productservice.domain.model.Product;
import com.restcode.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/v2/products")
public class ProductController {

    private final ProductService service;

    @PostMapping()
    public Product create(@RequestBody() Product product, @RequestParam() Long categoryId) {
        return service.create(categoryId, product);
    }

    @GetMapping()
    public List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public Product getOne(@PathVariable(name = "id") Long id) {
        return service.getOne(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOne(@PathVariable(name = "id") Long id) {
        return service.delete(id);
    }
}
