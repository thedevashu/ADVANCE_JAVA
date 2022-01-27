package com.java.miniproject.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.miniproject.dao.HibernateDao;
import com.java.miniproject.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String uname=req.getParameter("uname");
	String pass =req.getParameter("pass");
	System.out.println(uname+pass);
	HibernateDao db =new HibernateDao();
	
	User user =new User();
	user.setUname(uname);
	user.setPass(pass);
	
	if(db.validateUser(user)) {
//		req.setAttribute("user",uname);
		HttpSession session =req.getSession();
		session.setAttribute("user", user);
		
		RequestDispatcher rd =super.getServletContext().getRequestDispatcher("/welcom.jsp");
		rd.forward(req, resp);
	}
	else {
		RequestDispatcher rd =super.getServletContext().getRequestDispatcher("/error.jsp");
		rd.forward(req, resp);
	}
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
