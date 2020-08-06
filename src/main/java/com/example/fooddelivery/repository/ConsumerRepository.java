package com.example.fooddelivery.repository;

import com.example.fooddelivery.model.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Integer> {

  @Query(value = "select c from Consumer c where c.firstName=:firstName and c.lastName=:lastName")
  public Consumer findConsumerByName(String firstName, String lastName);
}