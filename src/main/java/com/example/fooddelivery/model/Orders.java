package com.example.fooddelivery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Orders {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private int orderId;

  @ManyToOne
  @JsonIgnore
  private Restaurant restaurant;

  @ManyToOne
  @JsonIgnore
  private Consumer consumer;

  @ManyToOne
  @JsonIgnore
  private Driver driver;

  @ManyToMany
  private Set<Item> items;

  public Orders() {
  }

  public Orders(int orderId, Restaurant restaurant, Consumer consumer, Set<Item> items, Driver driver) {
    this.setOrderId(orderId);
    this.setRestaurant(restaurant);
    this.setConsumer(consumer);
    this.setItems(items);
    this.setDriver(driver);
  }

  public Orders(Restaurant restaurant, Consumer consumer, Set<Item> items, Driver driver) {
    this.setRestaurant(restaurant);
    this.setConsumer(consumer);
    this.setItems(items);
    this.setDriver(driver);
  }

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public Restaurant getRestaurant() {
    return restaurant;
  }

  public void setRestaurant(Restaurant restaurant) {
    this.restaurant = restaurant;
  }

  public Consumer getConsumer() {
    return consumer;
  }

  public void setConsumer(Consumer consumer) {
    this.consumer = consumer;
  }

  public Set<Item> getItems() {
    return items;
  }

  public void setItems(Set<Item> items) {
    this.items = items;
  }

  public Driver getDriver() {
    return driver;
  }

  public void setDriver(Driver driver) {
    this.driver = driver;
  }

}