<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page errorPage="errorhandle.jsp" isErrorPage="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Square</title>
</head>
<body>
<form>
	<input type="text" name="num" >
	<input type="submit" value="ok">
	<%String s =request.getParameter("num");
	System.out.println(s);
	
	if(s != null){
		int num=Integer.parseInt(s);
		num = num* num;
		System.out.println(s);
	%>
	<h1>Square is<%=num %></h1>
	<%}%>
	</form>
</body>
</html>