package study.jdbc.preparestatment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PrepareStatmentExample {
	static Connection con;
	public static void main(String[] args) {
		setConnection();
		enterQuery();
	}
	public static void enterQuery() {
		Scanner sc =new Scanner(System.in);
		// product_id | product_name | product_cost | product_desc  | product_expiry_date
		String sql ="insert into product values (?,?,?,?,?)";
		try {
			//preparing sql statment
			PreparedStatement prep =con.prepareStatement(sql);
			Date date=null ;
			
			System.out.println("Enter product_id");
			prep.setInt(1, sc.nextInt());
			System.out.println("Enter product_name");
			prep.setString(2, sc.next());
			System.out.println("Enter product_cost");
			prep.setInt(3, sc.nextInt());
			System.out.println("Enter product_desc");
			prep.setString(4, sc.next());
			System.out.println("Enter product_expiry_date(yyyy-mm-dd)");
			prep.setDate(5, date.valueOf(sc.next()));
			
			prep.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection setConnection() {
		//Load driver in Jvm class area
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//connect to url
			
			String url ="jdbc:mysql://localhost:3306/advjava";
			String uname ="root";
			String pass="root";
			
			//make connection
			con=DriverManager.getConnection(url,uname,pass);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
}
