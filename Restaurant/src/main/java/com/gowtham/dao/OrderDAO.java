package com.gowtham.dao;

import java.sql.Types;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.gowtham.model.Order;
import com.gowtham.model.Seat;
import com.gowtham.util.ConnectionUtil;

public class OrderDAO {
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(final Order order) {
		final String sql = "insert into ORDERS (SEAT_NUMBER,TOTAL_PRICE,STATUS) VALUES(?,?,?)";
		final Object[] params = { order.getSeat().getNumber(), order.getTotalPrice(), order.getStatus() };
		final int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);
	}

	public void update(final Integer id, final String status) {
		final String sql = "update ORDERS set STATUS=? where ID=?";
		final int rows = jdbcTemplate.update(sql, status, id);
		System.out.println("No of rows updated: " + rows);
	}

	public void delete(final Integer id) {

		final String sql = "delete from ORDERS WHERE ID=?";
		final int rows = jdbcTemplate.update(sql, id);
		System.out.println("No of rows deleted: " + rows);
	}

	public void list() {
		final String sql = "SELECT ID,SEAT_NUMBER,TOTAL_PRICE,STATUS FROM ORDERS";
		final List<Order> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			final Order order = new Order();
			order.setId(rs.getInt("ID"));
			final Seat seat = new Seat();
			seat.setNumber(rs.getInt("SEAT_NUMBER"));
			order.setSeat(seat);
			order.setTotalPrice(rs.getInt("TOTAL_PRICE"));
			order.setStatus(rs.getString("STATUS"));
			return order;
		});
		final ListIterator<Order> listIterator = list.listIterator();
		while (listIterator.hasNext()) {
			final Order order = listIterator.next();
			System.out.println("ID : " + order.getId() + " " + "SEAT NUMBER : " + order.getSeat().getNumber() + " "
					+ "TOTAL PRICE : " + order.getTotalPrice() + " " + "STATUS : " + order.getStatus());
		}
	}

	public void isAvailable(Integer id) {
		String sql = "select isfood_available(?)";
		Object[] args = { id };
		System.out.println(jdbcTemplate.queryForObject(sql, args, Boolean.class));
	}

	public void placeOrder(Integer seatNumber, String itemName, String quantity) {
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate);
		call.withProcedureName("place_orders");
		call.declareParameters(new SqlParameter("lseat_number", Types.TINYINT),
				new SqlParameter("litem_name", Types.VARCHAR), new SqlParameter("lquantity", Types.VARCHAR),
				new SqlOutParameter("result", Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);
		MapSqlParameterSource in = new MapSqlParameterSource();
		in.addValue("lseat_number", seatNumber);
		in.addValue("litem_name", itemName);
		in.addValue("lquantity", quantity);

		Map<String, Object> execute = call.execute(in);
		String status = (String) execute.get("result");
		System.out.println(status);
	}

	public void cancelOrder(Integer orderId) {
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate);
		call.withProcedureName("cancel_order");
		call.declareParameters(new SqlParameter("lid", Types.INTEGER), new SqlOutParameter("result", Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);
		MapSqlParameterSource in = new MapSqlParameterSource();
		in.addValue("lid", orderId);
		Map<String, Object> execute = call.execute(in);
		String status = (String) execute.get("result");
		System.out.println(status);
	}

	public void cancelFoodOrder(Integer orderId, String foodname) {
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate);
		call.withProcedureName("cancel_food_order");
		call.declareParameters(new SqlParameter("lid", Types.INTEGER), new SqlParameter("lfood_name", Types.VARCHAR),
				new SqlOutParameter("result", Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);
		MapSqlParameterSource in = new MapSqlParameterSource();
		in.addValue("lid", orderId);
		in.addValue("lfood_name", foodname);
		Map<String, Object> execute = call.execute(in);
		String status = (String) execute.get("result");
		System.out.println(status);
	}

}
