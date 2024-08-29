package com.main.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepository {

	public ResultSet fetchProductsByCustomerId(String sql, Connection con) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(sql);
		return pstmt.executeQuery(sql);
		 
	}

}
