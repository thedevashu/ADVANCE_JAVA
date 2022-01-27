package study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Greet")
public class HelloHundredServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//taking input parameter to inputNum through name attribute in request
		String inputNum=req.getParameter("num");
		System.out.println("Inside doGet");
		int num=Integer.parseInt(inputNum);
		//creating print writer to write html on dom
		PrintWriter pw =resp.getWriter();
		
		pw.append("<html><body>");
		for(int i=1;i<=num;i++)
			pw.append("<h1>"+i+" Namaskar!</h1>");
		pw.append("</body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
		System.out.println("Inside doPost");
	}

}
