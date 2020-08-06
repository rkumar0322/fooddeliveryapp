package com.example.fooddelivery.model;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Consumer {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column
  private int consumerId;

  @Column
  private String firstName;

  @Column
  private String lastName;

  @OneToMany
  private Set<Orders> orders;

  public Consumer() {  }

  public Consumer(String firstName, String lastName,Set<Orders> orders) {
    this.setFirstName(firstName);
    this.setLastName(lastName);
    this.setOrders(orders);
  }

  public Consumer(int consumerId, String firstName, String lastName,Set<Orders> orders) {
    this.setConsumerId(consumerId);
    this.setFirstName(firstName);
    this.setLastName(lastName);
    this.setOrders(orders);
  }

  public int getConsumerId() {
    return consumerId;
  }

  public void setConsumerId(int consumerId) {
    this.consumerId = consumerId;
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

  @Override
  public String toString() {
    return "Blog{" +
        "id=" + consumerId +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}