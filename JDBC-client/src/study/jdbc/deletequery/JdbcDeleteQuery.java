package study.jdbc.deletequery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcDeleteQuery {
	static Connection connection;
	public static void main(String[] args) {
		setConnection();
		deleteSqlQuery();
	}

	private static void deleteSqlQuery() {
		//Create Statment for delete query
		
		try {
			Statement stm =connection.createStatement();
			System.out.println("Enter product id to be deleted");
			Scanner sc =new Scanner(System.in);
			int id =sc.nextInt();
			String sql ="delete from product where product_id="+id;
			
			stm.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void setConnection() {
		//Load driver into class area of jvm
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//connecting to url
			String url="jdbc:mysql://localhost:3306/advjava";
			String uname="root";
			String pass ="root";
			connection=DriverManager.getConnection(url,uname,pass);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
