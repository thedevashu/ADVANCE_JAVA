<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	Login Detail:
	<br>
	<form action="LoginServlet" method="post">
	UserName:<input type="text" id="uname" name="uname">
	<br>
	Password:<input type="password" id="pass" name="pass">
	<input type="submit" value="submit">
	</form>
</body>
</html>