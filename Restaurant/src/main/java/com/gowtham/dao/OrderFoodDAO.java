package com.gowtham.dao;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ListIterator;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gowtham.model.Food;
import com.gowtham.model.Order;
import com.gowtham.model.OrderFood;
import com.gowtham.util.ConnectionUtil;

public class OrderFoodDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
	public void save(final OrderFood orderFood){
		final String sql="insert into ORDER_FOOD_MAINTENANCE (ORDER_ID,FOOD_ID,QUANTITY,ORDERED_TIME,STATUS) VALUES(?,?,?,?,?)";
		final Object[] params={orderFood.getOrder().getId(),orderFood.getFood().getId(),orderFood.getQuantity(),orderFood.getOrderedTime(),orderFood.getStatus()};
		final int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: "+rows);
	}
	
	public void update(final Integer id,final String status){
		final String sql="update ORDER_FOOD_MAINTENANCE set STATUS=? where ID=?";
		final int rows = jdbcTemplate.update(sql,status,id);
		System.out.println("No of rows updated: "+rows);
	}
	
	public void delete(final Integer id){
		
		final String sql="delete from ORDER_FOOD_MAINTENANCE WHERE ID=?";
		final int rows = jdbcTemplate.update(sql, id);
		System.out.println("No of rows deleted: "+rows);
	}
	public void list(){
		final String sql="SELECT ID,ORDER_ID,FOOD_ID,QUANTITY,ORDERED_TIME,STATUS FROM ORDER_FOOD_MAINTENANCE";
		final List<OrderFood> list=jdbcTemplate.query(sql, (rs,rowNum)->{
			final OrderFood orderFood = new OrderFood();
			orderFood.setId(rs.getInt("ID"));
			final Order order = new Order();
			order.setId(rs.getInt("ORDER_Id"));
			orderFood.setOrder(order);
			final Food food = new Food();
			food.setId(rs.getInt("FOOD_ID"));
			orderFood.setFood(food);
			orderFood.setQuantity(rs.getInt("QUANTITY"));
			orderFood.setOrderedTime(rs.getTimestamp("ORDERED_TIME").toLocalDateTime());
			orderFood.setStatus(rs.getString("STATUS"));
			return orderFood;
		});
		final ListIterator<OrderFood> listIterator=list.listIterator();
		while(listIterator.hasNext()){
			final OrderFood orderFood = listIterator.next();
			System.out.println("ID : "+orderFood.getId()+" "+
			"ORDER ID : "+orderFood.getOrder().getId()+" "+
			"FOOD ID : "+orderFood.getFood().getId()+" "+
			"QUANTITY : "+orderFood.getQuantity()+" "+
			"ORDERED TIME : "+DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(orderFood.getOrderedTime())+" "+
			"STATUS : "+orderFood.getStatus());
		}
	}
	public void isOrdered(Integer orderId,Integer foodId){
		String sql="select isfood_ordered(?,?)";
		Object[] args={orderId,foodId};
		System.out.println(jdbcTemplate.queryForObject(sql, args, Boolean.class));
	}
}
