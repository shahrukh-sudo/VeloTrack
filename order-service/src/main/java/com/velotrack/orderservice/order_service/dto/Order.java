package com.velotrack.orderservice.order_service.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

  private Long orderId;
  private Long productId;
  private int quantity;
  private String status;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  // Getter and Setter for productId
  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  // Getter and Setter for quantity
  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  // Getter and Setter for status
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  // Getter and Setter for createdAt
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  // Getter and Setter for updatedAt
  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

}

