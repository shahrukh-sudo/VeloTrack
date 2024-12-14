package com.velotrack.orderservice.order_service.controller;


import com.velotrack.orderservice.order_service.dto.Order;
import com.velotrack.orderservice.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

  @Autowired
  private OrderService orderService;

  // Create a new order
  @PostMapping
  public ResponseEntity<String> createOrder(@RequestBody Order order) {
    orderService.createOrder(order);
    return new ResponseEntity<>("Order created successfully.", HttpStatus.CREATED);
  }

  // Get an order by ID
  @GetMapping("/{orderId}")
  public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
    Order order = orderService.getOrderById(orderId);
    return new ResponseEntity<>(order, HttpStatus.OK);
  }

  // Get all orders
  @GetMapping
  public ResponseEntity<List<Order>> getAllOrders() {
    List<Order> orders = orderService.getAllOrders();
    return new ResponseEntity<>(orders, HttpStatus.OK);
  }

  // Update the status of an order
  @PutMapping("/{orderId}/status")
  public ResponseEntity<String> updateOrderStatus(
      @PathVariable Long orderId,
      @RequestParam String status) {
    orderService.updateOrderStatus(orderId, status);
    return new ResponseEntity<>("Order status updated successfully.", HttpStatus.OK);
  }

  // Delete an order
  @DeleteMapping("/{orderId}")
  public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {
    orderService.deleteOrder(orderId);
    return new ResponseEntity<>("Order deleted successfully.", HttpStatus.OK);
  }
}
