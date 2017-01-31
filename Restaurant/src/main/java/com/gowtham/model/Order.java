package com.gowtham.model;

import lombok.Data;

@Data
public class Order {
private Integer id;
private Seat seat;
private Integer totalPrice;
private String status;
}
