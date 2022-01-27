package study.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.impl.ior.GenericTaggedComponent;

public class BookDAO {
	private Connection con=null;
	
	private Connection setConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava","root","root");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection Failed");
			e.printStackTrace();
		}
		
		return con;
		
	}//getConnection end
	
	public BookPojo getBookInfo(int id) {
		setConnection();
		BookPojo bp =new BookPojo();
		String sql="select * from books where id=?";
		try {
			PreparedStatement prep =con.prepareStatement(sql);
			prep.setInt(1, id);
			ResultSet rs =prep.executeQuery();
			if(rs.next()) {
				bp.setId(rs.getInt(1));
				bp.setBname(rs.getString("bname"));
				bp.setCost(rs.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bp;
	}//getBookInfo end
	
	public ArrayList<BookPojo> allBooks(){
		setConnection();
		
		ArrayList<BookPojo> books= new ArrayList<BookPojo>();
		try {
			PreparedStatement prep =con.prepareStatement("select * from books");
			ResultSet rs=prep.executeQuery();
			while(rs.next()) {
				BookPojo b =new BookPojo();
				b.setId(rs.getInt(1));
				b.setBname(rs.getString(2));
				b.setCost(rs.getInt(3));
				
				books.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}//allBooks end
}
