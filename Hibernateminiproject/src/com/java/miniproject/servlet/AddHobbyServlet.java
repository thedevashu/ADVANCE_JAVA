package com.java.miniproject.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.miniproject.dao.HibernateDao;
import com.java.miniproject.dao.HibernateDao;
import com.java.miniproject.entity.Hobby;
import com.java.miniproject.entity.User;

/**
 * Servlet implementation class AddHobbyServlet
 */
@WebServlet("/AddHobby")
public class AddHobbyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		User currUser =(User) session.getAttribute("user");
		Set<Hobby> hobbies =new HashSet<>();
		if(request.getParameter("hobby1") != null)
		{
		Hobby hb =new Hobby();
		hb.setUserId(currUser);
		hb.setHobby(request.getParameter("hobby1"));
		
		hobbies.add(hb);
		}
		if(request.getParameter("hobby2") != null)
		{
		Hobby hb =new Hobby();
		hb.setUserId(currUser);
		hb.setHobby(request.getParameter("hobby2"));
		hobbies.add(hb);
		}
		if(request.getParameter("hobby3") != null)
		{
		Hobby hb =new Hobby();
		hb.setUserId(currUser);
		hb.setHobby(request.getParameter("hobby3"));
		hobbies.add(hb);
		}
		
		currUser.setHobbies(hobbies);
		HibernateDao dao = new HibernateDao();
		dao.addUser(currUser);
		RequestDispatcher rd =request.getRequestDispatcher("/welcom.jsp");
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
