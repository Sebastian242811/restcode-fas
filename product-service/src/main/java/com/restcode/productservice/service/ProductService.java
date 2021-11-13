package com.restcode.productservice.service;


import com.restcode.productservice.client.RestaurantClient;
import com.restcode.productservice.domain.model.Product;
import com.restcode.productservice.domain.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public Product create(Long categoryId, Product product){
        product.setCategory(categoryService.getCategory(categoryId));
        product.setEnabled(true);
        return productRepository.save(product);
    }

    public Product update(Product product) {
        Product existingPdt = getOne(product.getId());
        existingPdt.setDescription(product.getDescription());
        return productRepository.save(existingPdt);
    }

    public Product getOne(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public ResponseEntity<?> delete(Long id){
        Product product = getOne(id);
        productRepository.delete(product);
        return ResponseEntity.ok().build();
    }
}
