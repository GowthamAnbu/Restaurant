package com.gowtham.model;

import lombok.Data;

@Data
public class FoodDetails {
private Integer id;
private Food food;
private Session session;
private Integer quantity;
}
