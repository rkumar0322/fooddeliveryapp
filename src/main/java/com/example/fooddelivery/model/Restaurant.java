package com.example.fooddelivery.model;


import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Restaurant {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private int restaurantId;

  @Column
  private String restaurantName;

  @OneToMany
  private Set<Orders> orders;

  @OneToMany(cascade = CascadeType.ALL)
  private Set<Item> items;

  public Restaurant() {}

  public Restaurant(int restaurantId, String restaurantName) {
    this.setRestaurantId(restaurantId);
    this.setRestaurantName(restaurantName);
  }

  public Restaurant(int restaurantId, String restaurantName,Set<Orders> orders, Set<Item> items) {
    this.setRestaurantId(restaurantId);
    this.setRestaurantName(restaurantName);
    this.setItems(items);
    this.setOrders(orders);
  }

  public Restaurant(String restaurantName,Set<Orders> orders, Set<Item> items) {
    this.setRestaurantName(restaurantName);
    this.setItems(items);
    this.setOrders(orders);
  }



  public int getRestaurantId() {
    return restaurantId;
  }

  public void setRestaurantId(int restaurantId) {
    this.restaurantId = restaurantId;
  }

  public String getRestaurantName() {
    return restaurantName;
  }

  public void setRestaurantName(String restaurantName) {
    this.restaurantName = restaurantName;
  }

  public Set<Item> getItems() {
    return items;
  }

  public void setItems(Set<Item> items) {
    this.items = items;
  }

  public Set<Orders> getOrders() {
    return orders;
  }

  public void setOrders(Set<Orders> orders) {
    this.orders = orders;
  }
}
