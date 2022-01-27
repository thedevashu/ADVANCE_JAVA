<%@page import="com.java.miniproject.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%User user=(User)session.getAttribute("user"); %>
	<h3><%=user.getFname() %>Add Your Hobby</h3>
	<form action="AddHobby" method="post">
		Enter Hobby:<input type="text" name="hobby">
		<input type="submit" value="ok">
	</form>
</body>
</html>