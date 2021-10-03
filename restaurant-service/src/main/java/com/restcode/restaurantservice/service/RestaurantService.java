package com.restcode.restaurantservice.service;


import com.restcode.restaurantservice.domain.model.Restaurant;
import com.restcode.restaurantservice.domain.repository.RestaurantRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RestaurantService {
    private final RestaurantRepository repository;

    public Restaurant create(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    public Restaurant update(Restaurant restaurant) {
        Restaurant existingObj = getOne(restaurant.getId());
        existingObj.setName(restaurant.getName());
        existingObj.setAddress(restaurant.getAddress());
        return repository.save(existingObj);
    }

    public Restaurant getOne(Long id) {
        return repository.getById(id);
    }

    public List<Restaurant> getAll() {
        return repository.findAll();
    }

    public ResponseEntity<?> delete(Long id){
        Restaurant restaurant = getOne(id);
        repository.delete(restaurant);
        return ResponseEntity.ok().build();
    }
}
