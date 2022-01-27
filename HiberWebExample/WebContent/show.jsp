<%@page import="study.entity.GroceryProductEntity"%>
<%@page import="java.util.List"%>
<%@page import="study.DAO.HinernateDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%HinernateDAO hd =new HinernateDAO();
List<GroceryProductEntity> l =hd.detail();
for(GroceryProductEntity gp : l){
%>
<table border="3">
<tr>
<td><%=gp.getProductId() %></td>
<td><%=gp.getProductName() %></td>
<td><%=gp.getProductDesc() %></td>
<td><%=gp.getCost() %></td>
<td><%=gp.getUnit() %></td>
<td><%=gp.getExpiryDate() %></td>
</tr>

</table>

<%} %>
</body>
</html>