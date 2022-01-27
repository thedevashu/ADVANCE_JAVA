<%@page import="com.java.miniproject.pojo.Hobby"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.java.miniproject.db.DBManager"%>
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
	<%
		User user = (User) session.getAttribute("user");
	%>
	<h3>
		View Hobby of
		<%=user.getFname()%></h3>
	
		<%
			DBManager dm = new DBManager();
			ArrayList<Hobby> hobbies = dm.getHobby(user);
			
		%>
	<table>
		<tr>
			<th>Sr no.</th>
			<th>Hobby</th>
		</tr>
		<%
			for (Hobby h : hobbies) {
				
		%>
		<tr>
			
			<td><%=h.getHobby()%></td>
		</tr>
	</table>
	<%
		}
	%>
</body>
</html>