package com.springframework.myspringapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springframework.myspringapp.model.Category;
import com.springframework.myspringapp.model.Product;
import com.springframework.myspringapp.model.Vendor;

@Repository
public class ProductRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Product> getAllProducts() {
		String sql="select p.*,c.name as cat_name,v.name as vendor_name,seq from product p "
				+ " JOIN category c ON p.category_id = c.id "
				+ " JOIN vendor v ON p.vendor_id = v.id";
		return jdbcTemplate.query(sql, new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rst, int rowNum) throws SQLException {
				Category cat = new Category();
				cat.setName(rst.getString("cat_name"));
				cat.setSequence(rst.getInt("seq"));
				
				Vendor vendor = new Vendor();
				vendor.setName(rst.getString("vendor_name"));
				Product product = new Product( 
						 rst.getInt("id"), 
						 rst.getString("title"),
						 rst.getDouble("price"), 
						 rst.getDouble("discount"), 
						 rst.getInt("stock_quantity"),
						 cat, 
						 vendor
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
