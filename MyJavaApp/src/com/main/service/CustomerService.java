package com.main.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.model.Address;
import com.main.model.Customer;
import com.main.repository.CustomerRepository;
import com.main.repository.DBConnection;

public class CustomerService {

	private  CustomerRepository customerRepository = new CustomerRepository();
	 
	public List<Customer> fetchCustomerWithAddress() throws SQLException {
		String sql="select c.id,c.name,a.city,a.street_details  from customer c JOIN address a ON c.address_id = a.id";
		Connection con =DBConnection.getInstance().dbConnect();
		ResultSet rst = customerRepository.fetchCustomerWithAddress(sql,con);
		List<Customer> list = new ArrayList<>();
		while(rst.next()) {
			
			Address address = new Address(); 
			address.setCity(rst.getString("city"));
			address.setStreetAddress(rst.getString("street_details"));
			
			Customer customer = new Customer(); 
			customer.setId(rst.getInt("id"));
			customer.setName( rst.getString("name"));
			
			//attach address to customer 
			customer.setAddress(address);
			
			//add customer to list 
			list.add(customer);
		}
		
		DBConnection.getInstance().dbClose();
		return list;
	}

}
