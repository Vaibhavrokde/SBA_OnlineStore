package com.practice.onlinestore.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.onlinestore.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
