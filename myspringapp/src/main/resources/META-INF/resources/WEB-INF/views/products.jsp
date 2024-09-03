<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import ="java.util.*" %>
<%@page import ="com.springframework.myspringapp.model.Product" %>

<!DOCTYPE html>
	<html>
		<head>
			<style>
				.table_style{
					font-size: 1.5em;
					font-family: verdana;
					 
				}
			</style>	
		</head>
	 	<body>
			<h1>All Products</h1>
			<span> <%= request.getAttribute("msg")== null?"": request.getAttribute("msg") %> </span>

			<p><a href="/show-add-product">  +Add Product </a> </p>
			<%! 
				int i = 1;
			%>
			<% 
			   List<Product> list =  (List<Product>)request.getAttribute("pList"); 
			   List<Product> archivedList =  (List<Product>)request.getAttribute("archivedList"); 
			 %>
			 
			 <table border="1" >
				<tbody class="table_style">
				<tr> 
					<th>Sr.No</th>
					<th>Title</th>
					<th>Price</th>
					<th>Discount</th>
					<th>Stock Quantity</th>
					<th>Category Name</th>
					<th>Vendor Name</th>
					<th> Actions </th>
				</tr>
				<%
					for(Product p :list){
				%>
					<tr> 
						<td> <%=i++  %></td>
						<td><%=p.getTitle()  %></td>
						<td><%=p.getPrice()  %></td>
						<td><%=p.getDiscount()  %></td>
						<td><%=p.getStockQuantity()  %></td>
						<td><%=p.getCategory().getName()  %></td>
						<td><%=p.getVendor().getName()  %></td>
						<td> <a href="/delete-product?id=<%=p.getId()  %>"> delete </a></td>
					 </tr>	
				<%	
					}
				%>			
				</tbody>	
			  </table>
			  <br /><br />
			  <hr />
			  <h3>Archived Products</h3>
			  <table border="1" >
			  			<tbody class="table_style">
			  			<tr> 
			  				<th>Sr.No</th>
			  				<th>Title</th>
			  				<th>Price</th>
			  				<th>Discount</th>
			  				<th>Stock Quantity</th>
			  				<th>Category Name</th>
			  				<th>Vendor Name</th>
			  				<th> Actions </th>
			  			</tr>
			  			<%
			  				for(Product p :archivedList){
			  			%>
			  				<tr> 
			  					<td> <%=i++  %></td>
			  					<td><%=p.getTitle()  %></td>
			  					<td><%=p.getPrice()  %></td>
			  					<td><%=p.getDiscount()  %></td>
			  					<td><%=p.getStockQuantity()  %></td>
			  					<td><%=p.getCategory().getName()  %></td>
			  					<td><%=p.getVendor().getName()  %></td>
			  					<td> <a href="/restore-product?id=<%=p.getId()  %>"> Restore </a></td>
			  				 </tr>	
			  			<%	
			  				}
			  			%>			
			  			</tbody>	
			  		  </table>
		 </body>
	</html>