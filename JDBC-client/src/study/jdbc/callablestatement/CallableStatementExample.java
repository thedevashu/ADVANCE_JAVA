package study.jdbc.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import study.jdbc.preparestatment.PrepareStatmentExample;

public class CallableStatementExample {

	public static void main(String[] args) {
		Connection con =PrepareStatmentExample.setConnection();
		//Making callable statement for procedure
		String sql="call pro(?,?,?)";
		try {
			CallableStatement cl =con.prepareCall(sql);
			//need to register out parameter
			cl.registerOutParameter(3,Types.INTEGER);
			
			cl.setInt(1, 12);
			cl.setInt(2, 34);
			
			cl.execute();
			int sum =cl.getInt(3);
			System.out.println(sum);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
