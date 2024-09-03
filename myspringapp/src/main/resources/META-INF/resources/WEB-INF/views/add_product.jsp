<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.springframework.myspringapp.model.*" %>
  <!DOCTYPE html>
	<html>
	 
		<body>
			<h1>Add New Product</h1>
			<%
				List<Category> catList = (List<Category>)request.getAttribute("catList");
				List<Vendor> vendorList = (List<Vendor>)request.getAttribute("vendorlist");	
			%>
			<div>
				<span> <%= request.getAttribute("msg")== null?"": request.getAttribute("msg") %> </span>
				<form method="post" action="/add-product">
					 <div>
						<label>Enter Name: </label>
						<input type="text" name="name" >
					 </div>
					 <div>
					 	<label>Enter Price: </label>
					 	<input type="number" name="price" >
					 </div>	
					 <div>
					 	<label>Enter Discount: </label>
					 	<input type="number" name="discount" >
					 </div>	
					 <div>
					 	<label>Enter Current Stock Qty: </label>
					 	<input type="number" name="qty" >
					 </div>	
					 <div>
						<label>Select Product Category:  </label>
					 	<select name="catId"> 
							<% 
							for(Category cat : catList){
							%>
							<option value="<%=cat.getId()%>"> <%= cat.getName()%> </option>
							<%
							}
							%>
							
						</select>	 
					 </div>	
					 <div>
					 <label>Select Vendor:  </label>
					 	<select name="vendorId"> 
							<% 
							for(Vendor v : vendorList){
							%>
							<option value="<%=v.getId()%>"> <%= v.getName()%> </option>
							<%
							}
							%>					 	 
					 </select>		 	 
					 </div>	
					 <div>
					 	 
					 	<input type="submit" value="Add Product details" >
					 </div>	
			
				</form>
				<p><a href="/all-products">All Products >> </a> </p>
			</div>	
		</body>
	</html>