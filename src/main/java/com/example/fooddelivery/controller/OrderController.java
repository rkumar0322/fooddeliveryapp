package com.example.fooddelivery.controller;

import com.example.fooddelivery.model.Consumer;
import com.example.fooddelivery.repository.ConsumerRepository;
import com.example.fooddelivery.model.Item;
import com.example.fooddelivery.repository.ItemRepository;
import com.example.fooddelivery.repository.OrderRepository;
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
public class OrderController {
  @Autowired
  OrderRepository fd;
  @Autowired
  RestaurantRepository r;

  @Autowired
  ItemRepository fd1;

  @Autowired
  ConsumerRepository fd2;

  @GetMapping("/orders")
  public List<Orders> index(){
    return fd.findAll();
  }

  @GetMapping("/order/{id}")
  public Orders show(@PathVariable String id){
    int consumerId = Integer.parseInt(id);
    return fd.findById(consumerId).get();
  }

  @PostMapping("/order")
  public Orders create(@RequestBody Map<String, Object> body) throws IllegalArgumentException {

    //Extract the Restaurant for the order
    Map<String,Object> restaurant = (Map<String,Object>)body.get("restaurant");
    String restaurantName = (String)restaurant.get("restaurant_name");
    Restaurant r1 = r.findByRestaurantName(restaurantName);
    if (r1 == null) {
      throw new IllegalArgumentException("Invalid Name");
    }

    //Extract the Consumer for the order
    Map<String,Object> consumer = (Map<String,Object>)body.get("consumer");
    String firstName = (String)consumer.get("first_name");
    String lastName = (String)consumer.get("last_name");
    Consumer c = fd2.findConsumerByName(firstName,lastName);
    if (fd2.findConsumerByName(firstName,lastName) == null) {
      throw new IllegalArgumentException("Invalid Name");
    }

    //extract the items from the input
    List<Map<String,Object>> items = (List<Map<String,Object>>)body.get("items");
    Set<Item> items2 = new HashSet<>();
    for(int i=0; i < items.size();i++) {
      String itemName = (String)items.get(i).get("item_name");
      Item it = fd1.findItem(restaurantName,itemName);
      if (it == null) {
        throw new IllegalArgumentException("Invalid Name");
      }
      items2.add(it);
    }
    Orders o = new Orders(r1,c,items2,null);
    return fd.save(o);
  }

  @PutMapping("/order/{id}")
  public Orders update(@PathVariable String id, @RequestBody Map<String, String> body){
    int consumerId = Integer.parseInt(id);
    // getting blog
    Orders c = fd.findById(consumerId).get();
    return fd.save(c);
  }

  @DeleteMapping("order/{id}")
  public boolean delete(@PathVariable String id){
    int consumerId = Integer.parseInt(id);
    // getting blog
    Orders c = fd.findById(consumerId).get();
    fd.delete(c);
    return true;
  }
}
