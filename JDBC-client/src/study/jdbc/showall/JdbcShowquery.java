package study.jdbc.showall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcShowquery {
	static Connection con;

	public static void main(String[] args) {
		setConnection();
		show();
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void show() {
		//Creating Statement to be executed
		
		try {
			Statement stm =con.createStatement();
			String sql ="select product_name,product_expiry_date from product";
			
			//Taking output in resutl set
			
			ResultSet rs =stm.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+", "+rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void setConnection() {
		//Load driver Class into JVM class area
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//connecting to url
			String url="jdbc:mysql://localhost:3306/advjava";
			String uname="root";
			String pass ="root";
			
			con=DriverManager.getConnection(url,uname,pass);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
