package study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EntertenmaintServlet
 */
@WebServlet("/Ente")
public class EntertenmaintServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String hobby1=req.getParameter("movie");
		String hobby2=req.getParameter("trek");
		String hobby3 =req.getParameter("cmusic");
		String hobby4=req.getParameter("rmusic");
		String hobby5=req.getParameter("party");
		String op=""+name+" likes ";
		if(hobby1==null)
			op+="";
		else
			op+=hobby1;
		if(hobby2==null)
			op+="";
		else
			op+=" and "+hobby2;
		if(hobby3==null)
			op+="";
		else
			op+=" and "+hobby3;
		if(hobby4==null)
			op+="";
		else
			op+=" and " +hobby4;
		if(hobby5==null)
			op+="";
		else
			op+=" and "+hobby5;
		op=op.replaceAll("and null and","\0");
		String html="<h2>"+op+" </h1>";
		html=html.replaceAll("null", "\0");
		
		PrintWriter pw =resp.getWriter();
		pw.append("<html><body>");
		pw.append(html);
		pw.append("</body></html>");
	}
}
