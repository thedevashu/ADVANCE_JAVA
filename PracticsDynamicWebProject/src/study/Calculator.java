package study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Calculator extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//taking parameters from request
		
		String ipNum1 =request.getParameter("num1");
		String ipNum2 =request.getParameter("num2");
		
		String op =request.getParameter("operator");
		int num1=Integer.parseInt(ipNum1);
		int num2 =Integer.parseInt(ipNum2);
		//creating print writer to write html on dom
		PrintWriter pw =response.getWriter();
				
		pw.append("<html><body>");
		if(op.equals("add")) {
			
			pw.append("<h1> addition="+(num1+num2)+"</h1>");
		}
		pw.append("</body></html>");
		
		
		
		System.out.println(num1+num2+op);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
