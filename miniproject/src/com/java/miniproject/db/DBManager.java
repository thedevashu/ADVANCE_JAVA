package com.java.miniproject.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.catalina.authenticator.jaspic.PersistentProviderRegistrations;

import com.java.miniproject.pojo.Hobby;
import com.java.miniproject.pojo.User;

public class DBManager {

	private Connection connect;

	public DBManager() {

	}

	public Connection getConnect() {
		return connect;
	}

	public void openConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project", "root", "root");
			System.out.println("DB connection successfull");
			
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
			System.out.println("the driver class is not found in the classpath");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ArrayList<Hobby> getHobby(User currUser) {
		openConnection();
		ArrayList<Hobby> hlist = new ArrayList<>();
		String sql="select * from user_hobby where user_id=?";
		try {
			PreparedStatement prep =connect.prepareStatement(sql);
			prep.setInt(1, currUser.getId());
			
			ResultSet rs =prep.executeQuery();
			
			while(rs.next()) {
				Hobby hobby =new Hobby();
				hobby.setHobbyId(rs.getInt(1));
				hobby.setUserId(rs.getInt(2));
				hobby.setHobby(rs.getString("hobby"));
				
				hlist.add(hobby);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
		if(hlist == null) {
			Hobby noHobby = new Hobby();
			noHobby.setHobby("No Hobby to show!!");
			hlist.add(noHobby);
			return hlist;
		}
		else {
			return hlist;
		}
	}

	public void closeConnection() {
		try {
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean validateUser(User user)
	{
		//connct db
		openConnection();
		String query = "select * from user_info where username = '"+user.getUname()+ "' and password = '"+user.getPass()+"'";
		//fire query
		try {
			
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			//validate output
			if(rs.next()) {
				user.setId(rs.getInt(1));
				user.setFname(rs.getString(2));
				user.setLname(rs.getString(3));
				user.setEmailId(rs.getString(4));
				user.setMobileNo(rs.getString(5));
				
				return true;
				}
			else
				return false;
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			//close conncetion
			closeConnection();
		}
	
		//return value
		return false;
	}

	public void addUser(User nUser) {

		openConnection();
		String sql="insert into user_info values (?,?,?,?,?,?,?)";
		try {
			PreparedStatement prep =connect.prepareStatement(sql);
			
			prep.setInt(1, nUser.getId());
			prep.setString(2, nUser.getFname());
			prep.setString(3, nUser.getLname());
			prep.setString(4, nUser.getEmailId());
			prep.setString(5, nUser.getMobileNo());
			prep.setString(6, nUser.getUname());
			prep.setString(7, nUser.getPass());
			
			prep.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
	}

	public void addHobby(Hobby hb) {
		openConnection();
		String sql ="INSERT INTO USER_HOBBY VALUES(DEFAULT,?,?)";
		try {
			PreparedStatement prep =connect.prepareStatement(sql);
			prep.setInt(1, hb.getUserId());
			prep.setString(2, hb.getHobby());
			
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
		
		
	}

//	public static void main(String[] args) {
//		DBManager obj = new DBManager();
//		boolean result = obj.validateUser("anil", "anil@123");
//		System.out.println(result);
//	}

}