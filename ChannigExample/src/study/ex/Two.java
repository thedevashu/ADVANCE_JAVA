package study.ex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Two
 */
@WebServlet("/Two")
public class Two extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String data=(String) req.getAttribute("data") + " Namaskar inside two";
		req.setAttribute("data", data);
		
		RequestDispatcher rd = super.getServletContext().getRequestDispatcher("/Three");
		rd.forward(req, resp);
	}

}
