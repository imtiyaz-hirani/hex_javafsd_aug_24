<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import ="java.util.*" %>
 <!DOCTYPE html>
	<html>
		<head>
		</head>
		<body>
			<h1>this is my home page!!!!! </h1>
			<p>Controller says : <%=request.getAttribute("msg") %> </p>
			<p>
				Array from controller: 
				<% 
				  List<Integer> list = (List<Integer>) request.getAttribute("intList"); 
				  
				  for(int i:list){
					out.println(i + "   "); 
				} 
				  %>
				
			</p>
		</body>
	</html>
