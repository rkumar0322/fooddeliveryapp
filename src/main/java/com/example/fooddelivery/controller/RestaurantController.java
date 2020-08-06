package com.example.fooddelivery.controller;

import com.example.fooddelivery.model.Item;
import com.example.fooddelivery.model.Orders;
import com.example.fooddelivery.model.Restaurant;
import com.example.fooddelivery.repository.RestaurantRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {
  @Autowired
  RestaurantRepository fd;

  @GetMapping("/restaurants")
  public List<Restaurant> index(){
    return fd.findAll();
  }

  @GetMapping("/restaurant/{id}")
  public Restaurant show(@PathVariable String id){
    int consumerId = Integer.parseInt(id);
    return fd.findById(consumerId).get();
  }

  @PostMapping("/restaurant")
  public Restaurant create(@RequestBody Map<String, String> body){
    String firstname = body.get("restaurant_name");
    return fd.save(new Restaurant(firstname,new HashSet<Orders>(),new HashSet<Item>()));
  }

  @PutMapping("/restaurant/{id}")
  public Restaurant update(@PathVariable String id, @RequestBody Map<String, String> body){
    int consumerId = Integer.parseInt(id);
    // getting blog
    Restaurant c = fd.findById(consumerId).get();
    c.setRestaurantName( body.get("restaurant_name"));
    return fd.save(c);
  }

  @DeleteMapping("restaurant/{id}")
  public boolean delete(@PathVariable String id){
    int consumerId = Integer.parseInt(id);
    // getting blog
    Restaurant c = fd.findById(consumerId).get();
    fd.delete(c);
    return true;
  }
}
