package study.ex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Third
 */
@WebServlet("/Three")
public class Third extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String data=(String) req.getAttribute("data") + "Showing from third servlet";
		
		resp.getWriter().append("<html><h1>"+data+"</h1></html>");
				
	}

}
