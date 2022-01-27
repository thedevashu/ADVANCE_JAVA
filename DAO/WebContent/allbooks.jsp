<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="study.dao.BookPojo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="study.dao.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AllBooks</title>
</head>
<body style="background-color:red;">
<center>
	
	<%BookDAO bdao =new BookDAO();
	ArrayList<BookPojo> list =bdao.allBooks();%>
	<table  border="2 solid green"><th>Id</th><th>Book name</th><th>Cost</th>
	<% 
	for(BookPojo bp:list){
	%>
	
	<tr><td><%=bp.getId() %></td><td><%=bp.getBname() %></td><td><%=bp.getCost() %></td></tr>
	</table>
	<%}//for end %>
	
	</center>
</body>
</html>