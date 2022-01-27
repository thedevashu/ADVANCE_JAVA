<%@page import="study.dao.BookPojo"%>
<%@page import="study.dao.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find Book</title>
</head>
<body>
<form>
	Enter book id:<input type="number" name="id">
	<input type="submit" value="ok">
</form>
<% 
String id=request.getParameter("id");
if(id != null && id != ""){
	BookDAO bd= new BookDAO();
	BookPojo bp = bd.getBookInfo(Integer.parseInt(id));

%>
<table border="2 solid red">
<tr><th>Id</th><th>Book name</th><th>Cost</th></tr>
<tr><td><%=bp.getId() %></td><td><%=bp.getBname() %></td><td><%=bp.getCost() %></td></tr>
</table>
<%} 
else{
%>Pls Enter Valid Book id<%} %>
</body>
</html>