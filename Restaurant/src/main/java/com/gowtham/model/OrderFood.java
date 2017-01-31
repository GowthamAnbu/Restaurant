package com.gowtham.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderFood {
private Integer id;
private Order order;
private Food food;
private Integer quantity;
private LocalDateTime orderedTime;
private String status;
}
