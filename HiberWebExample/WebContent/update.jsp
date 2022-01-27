<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<pre>
	<form action="update" method="get">
	Enter product id to be changed:<input type="number" name="id">
		
	
	<p>What do you Want to change</p>
	<select name="choice">
	<option>name</option>
	<option>cost</option>
	<option>unit</option>
	<option>desc</option>
	<option>date</option>
	</select>
	<input type="text" name="data">
	<input type="submit" value="ok">				
	</form>
</pre>
</body>
</html>