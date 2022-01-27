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

/**
 * Servlet implementation class SaveBook
 */
@WebServlet("/savebook")
public class SaveBook extends HttpServlet {
	Connection con=null;
	@Override
	public void init() throws ServletException {
		//set db connection
		//load driver in jvm class area
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//setup url to db connection
			String url="jdbc:mysql://localhost:3306/advjava";
			String uname="root";
			String pass="root";
			
			con=DriverManager.getConnection(url,uname,pass);
			System.out.println(con);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//end of init
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("idsearch");
		String sql="select bname,bcost from books where id=?";
		try {
			PreparedStatement prep =con.prepareStatement(sql);
			prep.setString(1, id);
			ResultSet rs =prep.executeQuery();
			PrintWriter pw =resp.getWriter();
			String nm = null;
			String cst = null;
			while(rs.next()) {
				nm=rs.getString(1);
				cst=rs.getString(2);
			}
			pw.append("<html><body>");
			pw.append("<h1>book name:"+nm+","+"book cost:"+cst);
			pw.append("</h1></body></html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}//end of post
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Get data from user
		String id =req.getParameter("id");
		String bname=req.getParameter("bname");
		String bcost=req.getParameter("bcost");
		
		String sql="insert into books values(?,?,?)";
		try {
			PreparedStatement prep =con.prepareStatement(sql);
			prep.setString(1, id);
			prep.setString(2, bname);
			prep.setString(3, bcost);
			
			prep.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter pw =resp.getWriter();
		pw.append(id+bname+bcost);
		
		
		
		
		
	}//end of doget
	
	@Override
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
