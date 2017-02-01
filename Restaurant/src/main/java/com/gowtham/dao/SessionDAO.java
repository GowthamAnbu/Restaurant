package com.gowtham.dao;

import java.time.LocalTime;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gowtham.model.Session;
import com.gowtham.util.ConnectionUtil;

public class SessionDAO {
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
	public int save(final Session session) {

		final String sql = "insert into SEED_SESSION(ID,NAME,START_TIME,END_TIME) values(?,?,?,?)";
		final Object[] params = { session.getId(),session.getName(),session.getStartTime(),session.getEndTime()};
		return jdbcTemplate.update(sql, params);

	}
	
	public int update(final Integer id,final LocalTime startTime,final LocalTime endTime) {

		final String sql = "update SEED_SESSION set START_TIME=?,END_TIME=? where ID=?";
		return jdbcTemplate.update(sql,startTime,endTime,id);

	}
	
	public int delete(final Integer id) {

		final String sql = "delete from SEED_SESSION where ID=?";
		return jdbcTemplate.update(sql, id);

	}
	public List<Session> list(){
	final String sql="SELECT ID,NAME,START_TIME,END_TIME FROM SEED_SESSION";
	return jdbcTemplate.query(sql,(rs,rowNum)->{
		final Session session = new Session();
		session.setId(rs.getInt("ID"));
		session.setName(rs.getString("NAME"));
		session.setStartTime(rs.getTime("START_TIME").toLocalTime());
		session.setEndTime(rs.getTime("END_TIME").toLocalTime());
		return session;
	});
	}
	
}
