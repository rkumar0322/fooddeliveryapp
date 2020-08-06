package com.example.fooddelivery.controller;

import com.example.fooddelivery.model.Driver;
import com.example.fooddelivery.repository.DriverRepository;
import com.example.fooddelivery.model.Orders;
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
public class DriverController {
  @Autowired
  DriverRepository fd;

  @GetMapping("/driver")
  public List<Driver> index(){
    return fd.findAll();
  }

  @GetMapping("/driver/{id}")
  public Driver show(@PathVariable String id){
    int consumerId = Integer.parseInt(id);
    return fd.findById(consumerId).get();
  }

  @PostMapping("/driver")
  public Driver create(@RequestBody Map<String, String> body){
    String firstname = body.get("first_name");
    String lastname = body.get("last_name");
    return fd.save(new Driver(firstname, lastname,new HashSet<Orders>()));
  }

  @PutMapping("/driver/{id}")
  public Driver update(@PathVariable String id, @RequestBody Map<String, String> body){
    int consumerId = Integer.parseInt(id);
    // getting blog
    Driver c = fd.findById(consumerId).get();
    c.setFirstName( body.get("first_name"));
    c.setLastName(body.get("last_name"));
    return fd.save(c);
  }

  @DeleteMapping("driver/{id}")
  public boolean delete(@PathVariable String id){
    int consumerId = Integer.parseInt(id);
    // getting blog
    Driver c = fd.findById(consumerId).get();
    fd.delete(c);
    return true;
  }
}