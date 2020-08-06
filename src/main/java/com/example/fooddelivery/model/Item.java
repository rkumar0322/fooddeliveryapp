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
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private int itemId;

  @Column
  private String itemName;

  @ManyToMany
  @JsonIgnore
  private Set<Orders> orders;

  @ManyToOne
  @JsonIgnore
  private Restaurant restaurant;

  public Item() {
  }

  public Item(int itemId, String itemName,Set<Orders> orders, Restaurant restaurant) {
    this.setRestaurant(restaurant);
    this.setItemId(itemId);
    this.setItemName(itemName);
    this.setOrders(orders);
  }

  public Item(String itemName,Set<Orders> orders, Restaurant restaurant) {
    this.setRestaurant(restaurant);
    this.setItemName(itemName);
    this.setOrders(orders);
  }

  public Restaurant getRestaurant() {
    return restaurant;
  }

  public void setRestaurant(Restaurant restaurant) {
    this.restaurant = restaurant;
  }

  public int getItemId() {
    return itemId;
  }

  public void setItemId(int itemId) {
    this.itemId = itemId;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public Set<Orders> getOrders() {
    return orders;
  }

  public void setOrders(Set<Orders> orders) {
    this.orders = orders;
  }

}
