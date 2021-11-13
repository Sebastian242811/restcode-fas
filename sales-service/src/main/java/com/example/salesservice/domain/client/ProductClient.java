package com.example.salesservice.domain.client;

import com.example.salesservice.domain.reference.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "PRODUCT-SERVICE")
@RequestMapping(value = "api/v2/products")
public interface ProductClient {
    @GetMapping("{id}")
    Product getOne(@PathVariable(name = "id") Long id);
}
