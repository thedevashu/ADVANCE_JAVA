<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(session.isNew()){
	session.setAttribute("list", new ArrayList<>());
	System.out.println("session"+session.getCreationTime());
} 
else{
 	ArrayList<String> l =(ArrayList)session.getAttribute("list");
 	if(l == null){
 		l =new ArrayList();
 	}
 	l.add(request.getParameter("iteam"));
	for(String it: l){
%>
	<h3><%=it %></h3>
	
<%	}
}%>
	<form>
		select product:
		<select name="iteam">
		<option>book</option>
		<option>shoe</option>
		<option>bag</option>
		<option>t-shirt</option>
		<option>glows</option>
		</select>
		<input type="submit" value="ok">
	</form>
</body>
</html>