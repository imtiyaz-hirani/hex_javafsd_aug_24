package com.main.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private String userDB="root";
	private String passDB="techskillsit";  //ur SQL password : if not set then leave it ""
	private String urlDB="jdbc:mysql://localhost:3306/";
	private String dbName="ecom"; //ur DB name 
	private String driver="com.mysql.cj.jdbc.Driver";
	
	private Connection con; 
	/*Establishing the connection */
	
	private static DBConnection dbConnection;
	private DBConnection() { }
	
	static {
		dbConnection = new  DBConnection();
	}
	
	public static DBConnection getInstance() {
		return dbConnection;
	}
	
	public Connection dbConnect() {
		//load the driver
		try {
			Class.forName(driver);
			//System.out.println("Driver loaded");
		} catch (ClassNotFoundException e) {
			System.err.println("Driver loading Issue ");
		}
		//create the connection 
		try {
			con = DriverManager.getConnection(urlDB + dbName, userDB, passDB);
			//System.out.println("connection established");
		} catch (SQLException e) {
			System.err.println("Connection Create Issue ");
		}
		
		return con; 
		 
	}
	
	

	public void dbClose() {
		try {
			con.close();
			//System.out.println("DB Connection Close");
		} catch (SQLException e) {
			System.err.println("Connection Close Issue ");
		}
	}
	
	
	public Connection getCon() {
		return con;
	}

	public static void main(String[] args) {
		DBConnection db = new DBConnection();
		db.dbConnect();
		db.dbClose();
	}
}
