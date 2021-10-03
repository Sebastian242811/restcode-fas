package com.restcode.restaurantservice.domain.repository;

import com.restcode.restaurantservice.domain.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}