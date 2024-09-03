package com.springframework.myspringapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springframework.myspringapp.model.Product;

@Repository
public class ProductRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Product> getAllProducts() {
		String sql="select *  from product";
		return jdbcTemplate.query(sql, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rst, int rowNum) throws SQLException {
				Product product = new Product( rst.getInt("id"), 
						 rst.getString("title"),
						 rst.getDouble("price"), 
						 rst.getDouble("discount"), 
						 rst.getInt("stock_quantity")  
						  );
				 
				return product;
			}
			
		});
		 
	}
	
	public List<String> getAllProductTitle() {
		String sql="select title   from product";
		return  jdbcTemplate.queryForList(sql, String.class);
		  
	}
}
