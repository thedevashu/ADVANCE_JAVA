package com.java.miniproject.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.miniproject.db.DBManager;
import com.java.miniproject.pojo.User;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUser")
public class AddUserServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User nUser=new User();
		
		nUser.setId(Integer.parseInt(request.getParameter("id")));
		nUser.setFname(request.getParameter("fname"));
		nUser.setLname(request.getParameter("lname"));
		nUser.setEmailId(request.getParameter("email"));
		nUser.setMobileNo(request.getParameter("mobile"));
		nUser.setUname(request.getParameter("uname"));
		nUser.setPass(request.getParameter("pass"));
		
		DBManager dm = new DBManager();
		dm.addUser(nUser);
		
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
