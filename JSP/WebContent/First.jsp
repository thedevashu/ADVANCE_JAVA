<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>From jsp</title>
</head>
<body>
<h1>Hello from jsp</h1>
<form >
	Enter Nmber<input type="number" name="num">
	<input type="submit" value="ok">
</form>

	
<%
String ip =request.getParameter("num");
if(ip != null){
int x=Integer.parseInt(ip);
for(int i=0;i<x;i++){ %>
<h3><%=i%>>Hello</h3>
<%}} %>

</body>
</html>