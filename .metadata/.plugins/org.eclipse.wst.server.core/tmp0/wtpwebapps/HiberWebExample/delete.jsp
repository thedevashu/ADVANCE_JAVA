<%@page import="study.DAO.HinernateDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>delete</title>
</head>
<body>
<form action="">
Enter id to delete:<input type="number" name="id">
<input type="submit" value="delete">
</form>
<%String id =request.getParameter("id");
if(id != null){
	HinernateDAO hd =new HinernateDAO();
	int pid =Integer.parseInt(id);
	hd.delete(pid);
	RequestDispatcher rd =request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);
}

%>
</body>
</html>