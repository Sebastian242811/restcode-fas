package com.restcode.restaurantservice.controller;

import com.restcode.restaurantservice.domain.model.Restaurant;
import com.restcode.restaurantservice.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/v2/restaurants")
public class RestaurantController {

    private final RestaurantService service;

    @PostMapping()
    public Restaurant create(@RequestBody() Restaurant restaurant) {
        return service.create(restaurant);
    }

    @GetMapping()
    public List<Restaurant> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public Restaurant getOne(@PathVariable(name = "id") Long id) {
        return service.getOne(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOne(@PathVariable(name = "id") Long id) {
        return service.delete(id);
    }
}