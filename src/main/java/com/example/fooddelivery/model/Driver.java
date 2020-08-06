package com.example.fooddelivery.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Driver {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private int driverId;

  @Column
  private String firstName;

  @Column
  private String lastName;

  @OneToMany
  private Set<Orders> orders;

  public Driver() {
  }

  public Driver(String firstName, String lastName, Set<Orders> orders) {
    this.setFirstName(firstName);
    this.setLastName(lastName);
    this.setOrders(orders);
  }

  public Driver(int driverId, String firstName, String lastName) {
    this.setDriverId(driverId);
    this.setFirstName(firstName);
    this.setLastName(lastName);
    this.setOrders(orders);
  }

  public int getDriverId() {
    return driverId;
  }

  public void setDriverId(int driverId) {
    this.driverId = driverId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Set<Orders> getOrders() {
    return orders;
  }

  public void setOrders(Set<Orders> orders) {
    this.orders = orders;
  }
}