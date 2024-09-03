package com.springframework.myspringapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springframework.myspringapp.model.Category;
@Repository
public class CategoryRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Category> getAllCategory() {
		 String sql="select * from category";
		 
		return jdbcTemplate.query(sql, new RowMapper<Category>() {

			@Override
			public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
				 Category c =new Category();
				 c.setId(rs.getInt("id"));
				 c.setName(rs.getString("name"));
				 c.setSequence(rs.getInt("seq"));
				return c;
			}
			
		});
	}
	
	
}
