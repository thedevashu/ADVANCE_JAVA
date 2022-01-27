package study.jdbc.preparestatment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PrepareStatmentSelect {

	public static void main(String[] args) {
		Connection con =PrepareStatmentExample.setConnection();
		
		showAllQuery(con);
//		deleteQuery(con);
//		selectQuery(con);
//		updateQuery(con);
		
		
	}

	public static void updateQuery(Connection con) {
		Scanner scn =new Scanner(System.in);
		String sql ="update product set product_desc =? where product_id=?" ;
		try {
			System.out.println("-------updateQuery---------");
			PreparedStatement prep =con.prepareStatement(sql);
			System.out.println("Enter product_id:");
			prep.setInt(2, scn.nextInt());
			System.out.println("Enter Desc:");
			prep.setString(1, scn.next());
			
			prep.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void deleteQuery(Connection con) {
		String sql="delete from product where product_id=?";
		Scanner sc =new Scanner(System.in);
		try {
			System.out.println("-------deleteQuery---------");
			PreparedStatement prep =con.prepareStatement(sql);
			System.out.println("Enter id to delete row");
			prep.setInt(1, sc.nextInt());
			prep.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void showAllQuery(Connection con) {
		String uname="cdac44";
		String dbPass=null;
		String dbName=null;
		String sql1="select pass from login_db where uname=?";
		String sql2="select uname from login_db where pass=?";
		try {
			PreparedStatement prep =con.prepareStatement(sql1);
			prep.setString(1, uname);
			
			ResultSet rs=prep.executeQuery();
			while(rs.next()) {
				dbPass=rs.getString(1);
			}
			prep =con.prepareStatement(sql2);
			prep.setString(1, "111");
			ResultSet rs2 =prep.executeQuery();
			
			while(rs2.next()) {
				dbName=rs2.getString(1);
			}
			System.out.println(dbPass+dbName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		String sql ="select product_name,product_expiry_date from product";
//		try {
//			PreparedStatement prep =con.prepareStatement(sql);
//			ResultSet rs = prep.executeQuery();
//			System.out.println("-------showAllQuery---------");
//			while (rs.next()) {
//				System.out.println(rs.getString(1)+" "+rs.getString(2));
//				
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	public static void selectQuery(Connection con) {
		Scanner sc =new Scanner(System.in);
		//Prepare Statement and sql query
		// product_id | product_name | product_cost | product_desc  | product_expiry_date
		String sql ="select * from product where product_id =?";
		try {
			System.out.println("-------selectQuery---------");
			PreparedStatement prep =con.prepareStatement(sql);
			System.out.println("Enter product_id");
			prep.setInt(1, sc.nextInt());
			ResultSet rs =prep.executeQuery();
			
			while(rs.next()) {
				int id =rs.getInt(1);
				String name =rs.getString(2);
				int cost =rs.getInt(3);
				String desc =rs.getString(4);
				String date =rs.getString(5);
				System.out.println(id+" "+name+" "+cost+" "+desc+" "+date);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
