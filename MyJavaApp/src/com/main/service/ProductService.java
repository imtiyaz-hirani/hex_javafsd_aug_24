package com.main.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.main.dto.ProductDto;
import com.main.model.Product;
import com.main.repository.DBConnection;
import com.main.repository.ProductRepository;

public class ProductService {

	DBConnection dbConnection = new DBConnection();
	ProductRepository productRepository = new ProductRepository();
	
	public List<ProductDto> fetchProductsByCustomerId(int cid) throws SQLException {
		String sql="select p.title,p.price,cp.date_of_purchase,v.name "
				+ " from customer c JOIN customer_product cp ON c.id = cp.customer_id "
				+ " JOIN product p ON cp.product_id = p.id "
				+ " JOIN vendor v ON p.vendor_id = v.id"
				+ " where c.id=" + cid;
		Connection con = dbConnection.dbConnect();
		ResultSet rst = productRepository.fetchProductsByCustomerId(sql,con);
		List<ProductDto> list = new ArrayList<>();
		while(rst.next()) { 
			ProductDto dto = 
						new ProductDto(rst.getString("title"), 
									   rst.getDouble("price"), 
									   LocalDate.parse(rst.getString("date_of_purchase")) , 
									   rst.getString("name"));
			list.add(dto);
		}
		
		dbConnection.dbClose();
		return list;
	}

	public List<Product> getAll() throws SQLException {
		 String sql="select * from product";
		 Connection con = dbConnection.dbConnect();
		 ResultSet rst = productRepository.fetchProducts(sql,con);
		 List<Product> list = new ArrayList<>();
		 while(rst.next()) {
			Product product = new Product( rst.getInt("id"), 
					 rst.getString("title"),
					 rst.getDouble("price"), 
					 rst.getDouble("discount"), 
					 rst.getInt("stock_quantity")  
					  );
			list.add(product);
		 }
		return list;
	}

}
