package com.velotrack.orderservice.order_service.service;

import com.velotrack.orderservice.order_service.dao.OrderDao;
import com.velotrack.orderservice.order_service.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

  @Autowired
  private OrderDao orderDao;

  // Create a new order
  public void createOrder(Order order) {
    orderDao.saveOrder(order);
  }

  // Get an order by ID
  public Order getOrderById(Long orderId) {
    return orderDao.findOrderById(orderId);
  }

  // Get all orders
  public List<Order> getAllOrders() {
    return orderDao.findAllOrders();
  }

  // Update the status of an order
  public void updateOrderStatus(Long orderId, String status) {
    int rowsUpdated = orderDao.updateOrderStatus(orderId, status);
    if (rowsUpdated == 0) {
      throw new IllegalArgumentException("Order with ID " + orderId + " does not exist.");
    }
  }

  // Delete an order
  public void deleteOrder(Long orderId) {
    int rowsDeleted = orderDao.deleteOrder(orderId);
    if (rowsDeleted == 0) {
      throw new IllegalArgumentException("Order with ID " + orderId + " does not exist.");
    }
  }
}
