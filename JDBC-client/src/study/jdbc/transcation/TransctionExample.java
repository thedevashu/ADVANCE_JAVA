package study.jdbc.transcation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import study.jdbc.preparestatment.PrepareStatmentExample;

public class TransctionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=PrepareStatmentExample.setConnection();
		
		//prepare statement
		try {
			con.setAutoCommit(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql="update trans set bal =? where acc_num = ? ";
		try {
			PreparedStatement prep =con.prepareStatement(sql);
			prep.setInt(1,9000);
			prep.setInt(2, 100);
			prep.execute();
			Scanner sc =new Scanner(System.in);
			sc.next();
			
			prep.setInt(1, 6000);
			prep.setInt(2, 101);
			int row = prep.executeUpdate();
			if(row == 0) {
				throw new SQLException();
			}
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
				System.out.println(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
