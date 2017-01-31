package com.gowtham.dao;

import java.util.List;
import java.util.ListIterator;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gowtham.model.Seat;
import com.gowtham.util.ConnectionUtil;

public class SeatDAO {

	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void save(final Seat seat) {

		final String sql = "insert into SEED_SEAT (SEAT_NUMBER,ACTIVE) values(?,?)";
		final Object[] params = { seat.getNumber(), seat.getActive() };
		final int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}
	
	public void delete(final Integer number)
	{
		final String sql="delete from SEED_SEAT where SEAT_NUMBER=?";
		final int rows = jdbcTemplate.update(sql,number);
		System.out.println("No of rows deleted: "+ rows);
	}
	
	public void list() {

		final String sql = "select SEAT_NUMBER,ACTIVE FROM SEED_SEAT";
		final List<Seat> list = jdbcTemplate.query(sql, (rs, rowNum) -> {
			final Seat seat = new Seat();
			seat.setNumber(rs.getInt("SEAT_NUMBER"));
			seat.setActive(rs.getBoolean("ACTIVE"));
			return seat;

		});	
		final ListIterator<Seat> listIterator=list.listIterator();
		while(listIterator.hasNext()){
			System.out.println(listIterator.next());
		}	
	}
	public Boolean isPresent(final Integer number){
		String sql="select isseat_number(?)";
		Object[] args={number};
		return jdbcTemplate.queryForObject(sql,args,Boolean.class);		
	}
	public void isActive(final Integer number){
		String sql="select isseat_number_active(?)";
		Object[] args={number};
		System.out.println(jdbcTemplate.queryForObject(sql, args, Boolean.class));
	}
}
