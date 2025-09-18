package com.kanchana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanchana.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
