package com.example.fooddelivery.repository;

import com.example.fooddelivery.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
  @Query(value = "select i from Item i where i.restaurant.restaurantName = :restaurantName and i.itemName = :itemName")
  Item findItem(@Param("restaurantName") String restaurantName, @Param("itemName") String itemName);
}