package com.springframework.myspringapp.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DBConfig {

	@Bean
	DataSource dataSource() {
		DataSource ds 
				= new DriverManagerDataSource(
							"jdbc:mysql://localhost:3306/ecom", 
							"root", 
							"techskillsit"); //use your password 
		return ds; 
	}

}

/*
 * 			DataSource <I>
 *    			|
 *    DriverManagerDataSource <C>
 *    
 *    super-ref = sub-class
 */