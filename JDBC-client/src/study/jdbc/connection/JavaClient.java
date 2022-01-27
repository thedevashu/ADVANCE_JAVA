package study.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JavaClient {
	static Connection con=null;
	static Scanner sc ;

	public static void main(String[] args) {
		
		connection();
		
		menu();
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	private static void menu() {
		sc=new Scanner(System.in);
		while(true) {
			System.out.println("Enter your No to Exit Yes to Continue");
			if(sc.next().equals("no")) {
				break;
			}
			else {
				
				Statement stmnt;
				try {
					stmnt = con.createStatement();
					//Writing query
					System.out.println("Enter Product name:");
					String pName=sc.next();
					System.out.println("Enter Product cost");
					int cost =sc.nextInt();
					System.out.println("Enter Product Description");
					String desc = sc.next();
					System.out.println("Enter Expire Date(yyyy-mm-dd):");
					String date=sc.next();
					
					String qry ="insert into product values (default,'"+pName+"',"+cost+",'"+desc+"','"+date+"')";
					//Executeing query
					stmnt.executeUpdate(qry);
					stmnt.close();
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
	}



	private static void connection() {
		try {
			//loading Driver class in JVM class region so its static method will run
			Class.forName("com.mysql.cj.jdbc.Driver");
			//making url,username,password
			String jdbcUrl="jdbc:mysql://localhost:3306/advjava";
			String uname="root";
			String pass="root";
			
			//setting connection
			con=DriverManager.getConnection(jdbcUrl,uname,pass);
			System.out.println(con);
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
