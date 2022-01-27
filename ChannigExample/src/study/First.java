package study;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class First
 */
@WebServlet("/First")
public class First extends HttpServlet {
	
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
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = req.getServletContext();
		
		RequestDispatcher rd =context.getRequestDispatcher("/Login.html");
		rd.forward(req, resp);
		
	}//end doGet
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname =req.getParameter("uname");
		String pass=req.getParameter("pass");
		
		ServletContext cont =req.getServletContext();
		String dbPass=db.get(uname);
		String op="";
		
		if(pass.equals(dbPass)) {
			req.setAttribute("name", uname);
			
			RequestDispatcher rd =cont.getRequestDispatcher("/Home");
			rd.forward(req, resp);
		}
		else {
			RequestDispatcher rd =cont.getRequestDispatcher("/ErrorServlet");
			rd.forward(req, resp);
		}
		
	}

}//end of first class
