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

}
