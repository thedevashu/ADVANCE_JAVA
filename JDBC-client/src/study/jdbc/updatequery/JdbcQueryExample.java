package study.jdbc.updatequery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcQueryExample {
	static Connection con;
	public static void main(String[] args) {
		setConnection();
		updateQuery();

	}
	private static void updateQuery() {
		//create statment update
		try {
			Statement stm = con.createStatement();
			System.out.println("Enter Product Id and new desc");
			Scanner scn =new Scanner(System.in);
			int id =scn.nextInt();
			String desc=scn.next();
			//update product set product_name='chadbury' where product_id=3;
			String sql="update product set product_desc='"+desc+"' where product_id="+id;
			
			stm.executeUpdate(sql);
			stm.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void setConnection() {
		//load driver in class area of JVM
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//set up url connection through DriverManager
			
			String url="jdbc:mysql://localhost:3306/advjava";
			String uname="root";
			String pass="root";
			
			con=DriverManager.getConnection(url,uname,pass);
			System.out.println(con);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
