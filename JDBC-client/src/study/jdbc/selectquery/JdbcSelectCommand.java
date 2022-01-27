package study.jdbc.selectquery;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcSelectCommand {
	static Connection con;
	public static void main(String[] args) {
		setConnection();
		fireSelectQuery();

	}
	private static void fireSelectQuery() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Product Id:");
		int pId=sc.nextInt();
		
		
		
		try {
			//create statment for con(connection)
			Statement stmnt =con.createStatement();
			String sql ="select * from product where product_id="+pId;
			//taking all output rows of sql query in resultset
			ResultSet rs = stmnt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString("product_name")+" "+rs.getString("product_expiry_date")+" "+rs.getString(3)+" "+ rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static void setConnection() {
		try {
			//Lloading Driver in jvm
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Setting url,username.password
			String url="jdbc:mysql://localhost:3306/advjava";
			String uname="root";
			String pass ="root";
			
			//connection set
			con=DriverManager.getConnection(url,uname,pass);
			System.out.println(con);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
