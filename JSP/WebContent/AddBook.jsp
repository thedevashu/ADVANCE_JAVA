<%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
	<pre>
		id:<input type="number" name="id">
		cost:<input type="number" name="cost">
		name:<input type="text" name="name">
		<input type="submit" value="ok">
	</pre>
</form>

	<%
	String id=request.getParameter("id");
	String cost =request.getParameter("cost");
	String name =request.getParameter("name");
	if(id != null){
	Connection con;
	Class.forName("com.mysql.cj.jdbc.Driver");
	//making url,username,password
	String jdbcUrl="jdbc:mysql://localhost:3306/advjava";
	String uname="root";
	String pass="root";
	
	//setting connection
	con=DriverManager.getConnection(jdbcUrl,uname,pass);
	System.out.println(con);
	String sql="insert into books values(?,?,?)";
	PreparedStatement prep =con.prepareStatement(sql);
	
	prep.setInt(1,Integer.parseInt(id) );
	prep.setString(2, name);
	prep.setInt(3, Integer.parseInt(cost));
	prep.executeUpdate();
	}
	%>
</body>
</html>