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
			<p><a href="#">  +Add Product </a></p>
			<%! 
				int i = 1;
			%>
			<% 
			   List<Product> list =  (List<Product>)request.getAttribute("pList"); 
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
						<td> <a href="/delete-product?id=<%=p.getId()  %>"> delete </a></td>
					 </tr>	
				<%	
					}
				%>			
				</tbody>	
			  </table>
		 </body>
	</html>