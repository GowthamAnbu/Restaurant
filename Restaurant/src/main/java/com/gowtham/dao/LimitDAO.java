package com.gowtham.dao;

import java.util.List;
import java.util.ListIterator;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gowtham.model.Limit;
import com.gowtham.util.ConnectionUtil;

public class LimitDAO {
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
	public void save(final Limit limit) {

		final String sql = "insert into SEED_LIMIT(ID,NAME,MAX_LIMIT) values(?,?,?)";
		final Object[] params = { limit.getId(),limit.getName(),limit.getMaxLimit()};
		final int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);

	}
	
	public void update(final Integer id,final Integer maxLimit) {

		final String sql = "update SEED_LIMIT set MAX_LIMIT=? where ID=?";
		final int rows = jdbcTemplate.update(sql,maxLimit,id);
		System.out.println("No of rows updated: " + rows);

	}
	
	public void delete(final Integer id) {

		final String sql = "delete from SEED_LIMIT where ID=?";
		final int rows = jdbcTemplate.update(sql, id);
		System.out.println("No of rows deleted: " + rows);

	}
	
	public void list(){
		final String sql="select ID,NAME,MAX_LIMIT FROM SEED_LIMIT";
		final List<Limit> list = jdbcTemplate.query(sql,(rs,rowNum)->{
			final Limit limit = new Limit();
			limit.setId(rs.getInt("ID"));
			limit.setName(rs.getString("NAME"));
			limit.setMaxLimit(rs.getInt("MAX_LIMIT"));
			return limit;
		});
		final ListIterator<Limit> listIterator=list.listIterator();
		while(listIterator.hasNext()){
			System.out.println(listIterator.next());
		}
		
	}
}
