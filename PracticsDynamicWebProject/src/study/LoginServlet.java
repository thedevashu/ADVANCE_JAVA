package study;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LoginServlet extends HttpServlet {
	
	HashMap<String, String> db;
	
	@Override
	public void init() throws ServletException {
		System.out.println("inside init()");
		db=new HashMap<>();
		db.put("cdac1", "111");
		db.put("cdac2", "222");
		db.put("cdac3", "333");
		db.put("cdac4", "444");
	}
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//taking uname and pass parameters
		String uname = request.getParameter("uname");
		String pass =request.getParameter("pass");
		
		
		//Printwriter for dom manipulation
		PrintWriter pw = response.getWriter();
		
		String dbPass=db.get(uname);
//		System.out.println(dbPass);
		String op="";
		
		if(pass.equals(dbPass)) {
			op="Login Sucess";
		}
		else {
			op="Login fail";
		}
		pw.append("<html><body>");
		pw.append("<h3 >"+op+"</h3>----");
		pw.append("</body></html>");
		
//		pw.append("<html><body>");
//		if(uname.equals("cdac") && pass.equals("bingo123")) {
//			pw.append("<h3>Login Sucess</h3>");
//			
//		}
//		else {
//			pw.append("<h3 >Login fail</h3>");
//		}
//		pw.append("</body></html>");
	}

}
