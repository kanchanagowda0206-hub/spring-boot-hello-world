package com.kanchana.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kanchana.entity.Order;
import com.kanchana.repository.OrderRepository;
import com.kanchana.requestdto.OrderRequestDto;
import com.kanchana.requestdto.Product;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	private RestTemplate restTemplate;

//starts from here
	public Order placeOrder(OrderRequestDto orderRequestDto) {
		Order order = new Order();
		order.setProductId(orderRequestDto.getProductId());
		order.setQuantity(orderRequestDto.getQuantity());
		order.setStatus("CREATED");

		// give call to product service to get qty - should have product-service URL
		// orderrQty*amount

		String productServiceURL = "http://localhost:8088/products/";
		Product product = restTemplate.getForEntity(productServiceURL + orderRequestDto.getProductId(), Product.class)
				.getBody();
		order.setAmount(product.getPrice() * order.getQuantity());

		// give call to product service to update stock
		// localhost:8083/products/1?orderQuantity=12
		String updateStockURL = productServiceURL + orderRequestDto.getProductId() + "?orderQuantity="
				+ orderRequestDto.getQuantity();
		restTemplate.put(updateStockURL, null);
		return orderRepository.save(order);
	}

	public Order getOrderById(int orderId) {
		return orderRepository.findById(orderId).get();
	}

	public List<Order> getAllOrder() {
		return orderRepository.findAll();
	}

}
