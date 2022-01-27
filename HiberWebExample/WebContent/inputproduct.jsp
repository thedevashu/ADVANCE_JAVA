<%@page import="study.DAO.HinernateDAO"%>
<%@page import="java.sql.Date"%>
<%@page import="study.entity.GroceryProductEntity"%>
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
<form action="index.jsp">
	Enter product id:<input type="number" name="id">
	Enter product name:<input type="text" name="pname">
	Enter product desc:<input type="text" name="desc">
	Enter product cost:<input type="number" name="cost">
	Enter product unit:<input type="number" name="unit">
	Enter product exp date(yyyy-mm-dd):<input type="date" name="edate">
	<input type="submit" value="insert">
</form>
</pre>

<%
	String id =request.getParameter("id");
	String pname =request.getParameter("pname");
	String desc =request.getParameter("desc");
	String cost =request.getParameter("cost");
	String unit =request.getParameter("unit");
	String edate =request.getParameter("edate");
	
	if( id != null){
		GroceryProductEntity gp =new GroceryProductEntity();
		gp.setProductName(pname);
		gp.setProductId(Integer.parseInt(id));
		gp.setCost(Integer.parseInt(cost));
		gp.setUnit(Integer.parseInt(unit));
		gp.setProductDesc(desc);
		gp.setExpiryDate(Date.valueOf(edate));
		
		HinernateDAO hb =new HinernateDAO();
		hb.insertRecord(gp);
		System.out.println(id+" "+edate);
	}
%>
</body>
</html>