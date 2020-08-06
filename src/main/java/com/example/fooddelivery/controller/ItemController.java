package com.example.fooddelivery.controller;

import com.example.fooddelivery.model.Item;
import com.example.fooddelivery.repository.ItemRepository;
import com.example.fooddelivery.model.Orders;
import com.example.fooddelivery.model.Restaurant;
import com.example.fooddelivery.repository.RestaurantRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
  @Autowired
  ItemRepository fd;
  @Autowired
  RestaurantRepository r;

  @GetMapping("/items")
  public List<Item> index(){
    return fd.findAll();
  }

  @GetMapping("/item/{id}")
  public Item show(@PathVariable String id){
    int consumerId = Integer.parseInt(id);
    return fd.findById(consumerId).get();
  }

  @PostMapping("/item")
  public Item create(@RequestBody Map<String, Object> body){
    String itemName = (String)  body.get("item_name");
    Map<String,Object> next = (Map<String,Object>)body.get("restaurant");
    String restaurant_name = (String)next.get("restaurant_name");
    List<Restaurant> a = r.findAll();
    for (int i = 0; i < a.size();i++) {
      Restaurant a1 = a.get(i);
      if (a1.getRestaurantName().equals(restaurant_name)) {
        Item saving = new Item(itemName,new HashSet<Orders>(),a1);
        Set<Item> its = a1.getItems();
        its.add(saving);
        a1.setItems(its);
        fd.save(saving);
      }
    }
    return null;
  }

  @PutMapping("/item/{id}")
  public Item update(@PathVariable String id, @RequestBody Map<String, String> body){
    int consumerId = Integer.parseInt(id);
    // getting blog
    Item c = fd.findById(consumerId).get();
    c.setItemName( body.get("item_name"));
    return fd.save(c);
  }

  @DeleteMapping("item/{id}")
  public boolean delete(@PathVariable String id){
    int consumerId = Integer.parseInt(id);
    // getting blog
    Item c = fd.findById(consumerId).get();
    fd.delete(c);
    return true;
  }
}
