package com.springframework.myspringapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springframework.myspringapp.model.Vendor;

@Repository
public class VendorRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Vendor> getAllVendors() {
		 String sql="select * from vendor";
		 
		return jdbcTemplate.query(sql, new RowMapper<Vendor>() {
			@Override
			public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException {
				Vendor v = new Vendor();
				v.setId(rs.getInt("id"));
				v.setName(rs.getString("name"));
				v.setCity(rs.getString("city"));
				return v;
			}
		});
	}
	
	
	
}
