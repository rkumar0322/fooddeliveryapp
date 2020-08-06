package com.example.fooddelivery.repository;

import com.example.fooddelivery.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

  @Query(value = "select r from Restaurant r where r.restaurantName = :restaurantName")
  Restaurant findByRestaurantName(@Param("restaurantName") String restaurantName);
}
