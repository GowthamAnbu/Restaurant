package com.gowtham.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gowtham.model.Seat;
import com.gowtham.util.ConnectionUtil;

public class SeatDAO implements DAO<Seat>{

	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	@Override
	public int save(final Seat seat) {

		final String sql = "INSERT INTO SEED_SEAT (SEAT_NUMBER,ACTIVE) VALUES(?,?)";
		final Object[] params = {seat.getNumber(),seat.getActive() };
		return jdbcTemplate.update(sql, params);

	}
	
	@Override
	public int update(final Seat seat) {

		final String sql = "UPDATE SEED_SEAT SET ACTIVE=? WHERE SEAT_NUMBER=?";
		final Object[] params = {seat.getActive(), seat.getNumber()};
		return jdbcTemplate.update(sql, params);

	}
	
	@Override
	public int delete(final Integer number){
		final String sql="DELETE FROM SEED_SEAT WHERE SEAT_NUMBER=?";
		return jdbcTemplate.update(sql,number);
	}
	
	@Override
	public List<Seat> findAll() {

		final String sql = "select SEAT_NUMBER,ACTIVE FROM SEED_SEAT";
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			final Seat seat = new Seat();
			seat.setNumber(rs.getInt("SEAT_NUMBER"));
			seat.setActive(rs.getBoolean("ACTIVE"));
			return seat;

		});
	}

	@Override
	public Seat findOne(final Integer id) {

		final String sql = "select SEAT_NUMBER,ACTIVE FROM SEED_SEAT WHERE SEATNUMBER=?";
		Object[] args={id};
		return jdbcTemplate.queryForObject(sql, args, (rs, rowNum) -> {
			final Seat s = new Seat();
			s.setNumber(rs.getInt("SEAT_NUMBER"));
			s.setActive(rs.getBoolean("ACTIVE"));
			return s;
		});
	}
	
	public Boolean isPresent(final Integer number){
		String sql="select isseat_number(?)";
		Object[] args={number};
		return jdbcTemplate.queryForObject(sql,args,Boolean.class);
	}
	
	
	public boolean isActive(final Integer number){
		String sql="select isseat_number_active(?)";
		Object[] args={number};
		return jdbcTemplate.queryForObject(sql, args, Boolean.class);
	}

}
