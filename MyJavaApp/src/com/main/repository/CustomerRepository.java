package com.main.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepository {

	DBConnection dbConnection = new DBConnection();
	 
	public ResultSet fetchCustomerWithAddress(String sql, Connection con) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		 
		return rst;
	}
}
/*
 * insert, update, delete :- pstmt.executeUpdate()
 * select: pstmt.executeQuery()
 * 
 */