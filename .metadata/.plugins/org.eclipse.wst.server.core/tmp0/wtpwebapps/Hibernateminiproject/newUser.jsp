<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New User</title>
</head>
<body>
<pre>
	<form action="AddUser" method="post">
	Enter new id:<input type="number" name="id">
	Enter first name:<input type="text" name="fname">
	Enter last name:<input type="text" name="lname">
	Enter email id:<input type="email" name="email">
	Enter mobile no:<input type="number" name="mobile">
	Enter User name:<input type="text" name="uname">
	Enter pass:<input type="password" name="pass">
	<input type="submit" value="create user">
	</form>
</pre>
</body>
</html>