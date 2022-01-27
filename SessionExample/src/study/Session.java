package study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.SessionEvent;

/**
 * Servlet implementation class Session
 */
@WebServlet("/Session")
public class Session extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session =req.getSession();
		resp.getWriter().append(session.getId());
		
		int c=0;
		if(session.isNew()) {
			c=1;
		}
		else
		{
			c=(int) session.getAttribute("count");
			c++;
		}
		session.setAttribute("count", c);
		
		resp.setContentType("text/html");
		
		resp.getWriter().append("<br>Session request in one session "+c+"<a href='logout'> logut</a>");
	}

}
