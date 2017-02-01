package com.gowtham.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gowtham.model.Limit;
import com.gowtham.util.ConnectionUtil;

public class LimitDAO implements DAO<Limit>{
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	
	@Override
	public int save(final Limit limit) {
		final String sql = "insert into SEED_LIMIT(ID,NAME,MAX_LIMIT) values(?,?,?)";
		final Object[] args = { limit.getId(),limit.getName(),limit.getMaxLimit()};
		return jdbcTemplate.update(sql, args);
	}
	
	@Override
	public int update(final Limit limit) {
		final String sql = "update SEED_LIMIT set MAX_LIMIT=? where ID=?";
		Object[] args={limit.getMaxLimit(),limit.getId()};
		return jdbcTemplate.update(sql,args);

	}
	
	@Override
	public int delete(final Integer id) {
		final String sql = "delete from SEED_LIMIT where ID=?";
		return jdbcTemplate.update(sql, id);
	}
	
	@Override
	public List<Limit> findAll(){
		final String sql="select ID,NAME,MAX_LIMIT FROM SEED_LIMIT";
		final List<Limit> list = jdbcTemplate.query(sql,(rs,rowNum)->{
			final Limit limit = new Limit();
			limit.setId(rs.getInt("ID"));
			limit.setName(rs.getString("NAME"));
			limit.setMaxLimit(rs.getInt("MAX_LIMIT"));
			return limit;
		});
		/*final ListIterator<Limit> listIterator=list.listIterator();
		while(listIterator.hasNext()){
			System.out.println(listIterator.next());
		}*/
		return list;
		
	}

	@Override
	public Limit findOne(final Integer id) {
		final String sql="select ID,NAME,MAX_LIMIT FROM SEED_LIMIT WHERE ID=?";
		Object[] args={id};
		final Limit limit = jdbcTemplate.queryForObject(sql, args, (rs,rowNum)->{
			final Limit l = new Limit();
			l.setId(rs.getInt("ID"));
			l.setName(rs.getString("NAME"));
			l.setMaxLimit(rs.getInt("MAX_LIMIT"));
			return l;
		});
		return limit;
	}
}
