package com.velotrack.orderservice.order_service.dao;

import com.velotrack.orderservice.order_service.dto.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class OrderDao {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  // SQL queries
  private static final String INSERT_ORDER = """
            INSERT INTO orders (product_id, quantity, status, created_at, updated_at)
            VALUES (?, ?, ?, ?, ?)
            """;

  private static final String SELECT_ORDER_BY_ID = """
            SELECT * FROM orders WHERE order_id = ?
            """;

  private static final String SELECT_ALL_ORDERS = """
            SELECT * FROM orders
            """;

  private static final String UPDATE_ORDER_STATUS = """
            UPDATE orders SET status = ?, updated_at = ? WHERE order_id = ?
            """;

  private static final String DELETE_ORDER = """
            DELETE FROM orders WHERE order_id = ?
            """;

  // Save a new order
  public int saveOrder(Order order) {
    return jdbcTemplate.update(INSERT_ORDER,
        order.getProductId(),
        order.getQuantity(),
        order.getStatus(),
        order.getCreatedAt(),
        order.getUpdatedAt());
  }

  // Find order by ID
  public Order findOrderById(Long orderId) {
    return jdbcTemplate.queryForObject(SELECT_ORDER_BY_ID, new OrderRowMapper(), orderId);
  }

  // Fetch all orders
  public List<Order> findAllOrders() {
    return jdbcTemplate.query(SELECT_ALL_ORDERS, new OrderRowMapper());
  }

  // Update order status
  public int updateOrderStatus(Long orderId, String status) {
    return jdbcTemplate.update(UPDATE_ORDER_STATUS, status, LocalDateTime.now(), orderId);
  }

  // Delete an order
  public int deleteOrder(Long orderId) {
    return jdbcTemplate.update(DELETE_ORDER, orderId);
  }

  // RowMapper to map ResultSet to Order object
  private static class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
      Order order = new Order();
      order.setOrderId(rs.getLong("order_id"));
      order.setProductId(rs.getLong("product_id"));
      order.setQuantity(rs.getInt("quantity"));
      order.setStatus(rs.getString("status"));
      order.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
      order.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
      return order;
    }
  }
}
