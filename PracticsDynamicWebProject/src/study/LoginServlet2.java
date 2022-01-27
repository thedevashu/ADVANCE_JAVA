package study;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login2")
public class LoginServlet2 extends HttpServlet {
	Connection con=null;
	@Override
	public void init() throws ServletException {

		//connection block
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/advjava";
			String uname="root";
			String pass="root";

			con=DriverManager.getConnection(url,uname,pass);
			System.out.println(con);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname =req.getParameter("uname");
		String pass =req.getParameter("pass");
		String dbPass=null;
		String dbName=null;
		
		String ip=uname+pass;
		String db="";
		PrintWriter pw =resp.getWriter();
		//statment
		String sql1="select uname,pass from login_db where uname=?";
		
		try {
			PreparedStatement prep =con.prepareStatement(sql1);
			prep.setString(1, uname);
			
			ResultSet rs=prep.executeQuery();
			while(rs.next()) {
				dbName=rs.getString(1);
				dbPass=rs.getString(2);
			}
			db=dbName+dbPass;
			System.out.println(dbPass+dbName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.append("<html><body>");
		if(db.equals(ip)) {
			pw.append("<h1>Login Done</h1>");
		}
		
		else {
			pw.append("<h1>Password or username incorrect!!!!!!</h1>");
		}
		pw.append("</html></body>");
		
	}

}
