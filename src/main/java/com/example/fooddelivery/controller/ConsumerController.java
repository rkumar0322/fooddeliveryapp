package com.example.fooddelivery.controller;
import com.example.fooddelivery.model.Consumer;
import com.example.fooddelivery.repository.ConsumerRepository;
import com.example.fooddelivery.model.Orders;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ConsumerController {
  @Autowired
  ConsumerRepository fd;

  @GetMapping("/consumers")
  public List<Consumer> index(){
    return fd.findAll();
  }

  @GetMapping("/consumer/{id}")
  public Consumer show(@PathVariable String id){
    int consumerId = Integer.parseInt(id);
    return fd.findById(consumerId).get();
  }

  @PostMapping("/consumer")
  public Consumer create(@RequestBody Map<String, String> body){
    String firstname = body.get("first_name");
    String lastname = body.get("last_name");
    return fd.save(new Consumer(firstname, lastname,new HashSet<Orders>()));
  }

  @PutMapping("/consumer/{id}")
  public Consumer update(@PathVariable String id, @RequestBody Map<String, String> body){
    int consumerId = Integer.parseInt(id);
    // getting blog
    Consumer c = fd.findById(consumerId).get();
    c.setFirstName( body.get("first_name"));
    c.setLastName(body.get("last_name"));
    return fd.save(c);
  }

  @DeleteMapping("consumer/{id}")
  public boolean delete(@PathVariable String id){
    int consumerId = Integer.parseInt(id);
    // getting blog
    Consumer c = fd.findById(consumerId).get();
    fd.delete(c);
    return true;
  }
}