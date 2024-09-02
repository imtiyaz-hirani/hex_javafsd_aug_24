<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import ="java.util.*" %>
<%@page import ="com.springframework.myspringapp.model.Product" %>

<!DOCTYPE html>
	<html>
	 	<body>
			<h1>All Products</h1>
			<% 
			   List<Product> list =  (List<Product>)request.getAttribute("pList"); 
			 %>
			 
			 <table border="1">
				<tr> 
					<td>ID</td>
					<td>Title</td>
					<td>Price</td>
					<td>Discount</td>
					<td>Stock Quantity</td>
					<td> Actions </td>
				</tr>
				<%
					for(Product p :list){
				%>
					<tr> 
						<td> <%=p.getId()  %></td>
						<td><%=p.getTitle()  %></td>
						<td><%=p.getPrice()  %></td>
						<td><%=p.getDiscount()  %></td>
						<td><%=p.getStockQuantity()  %></td>
						<td> <a href="/delete-product?id=<%=p.getId()  %>"> delete </a></td>
					 </tr>	
				<%	
					}
				%>				
			  </table>
		 </body>
	</html>