package com.kanchana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kanchana.entity.Order;
import com.kanchana.requestdto.OrderRequestDto;
import com.kanchana.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("/placeOrder")
	public Order placeOrder(@RequestBody OrderRequestDto orderRequestDto) {
	return	orderService.placeOrder(orderRequestDto);
	}
	
	@GetMapping("/{orderId}")
	public Order getOrderById(@PathVariable int orderId) {
	return	orderService.getOrderById(orderId);
	}
	
	@GetMapping("/all")
	public List<Order> getAllOrders(){
	return	orderService.getAllOrder();
	}
}
