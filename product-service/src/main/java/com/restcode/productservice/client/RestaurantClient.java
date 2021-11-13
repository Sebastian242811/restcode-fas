package com.restcode.productservice.client;

import com.restcode.productservice.domain.reference.Restaurant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "RESTAURANT-SERVICE")
@RequestMapping(value = "api/v2/restaurants")
public interface RestaurantClient {

    @GetMapping("{id}")
    Restaurant getOne(@PathVariable(name = "id") Long id);
}
