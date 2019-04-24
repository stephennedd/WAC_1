package nl.hu.v1wac.firstapp.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = "/CalculatorServlet.do")
public class CalculatorServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int num1 = Integer.parseInt(req.getParameter("number1"));
		int num2 = Integer.parseInt(req.getParameter("number2"));
		int num3 = num1 + num2;
		int num4 = num1 - num2;
		int num5 = num1 / num2;
		int num6 = num1 * num2;
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		if(req.getParameter("plus")!= null) {
			out.println("<!DOCTYPE html");
			out.println("<html>");
			out.println("  <title>Dynamic Example</title>");
			out.println("  <body>");
			out.println("    <h2>Calculator Add</h2>");
			out.println("    <h2>" + num3 + "</h2>");
			out.println("  </body>");
			out.println("</html>");
		}
		
		if(req.getParameter("min")!= null) {
			out.println("<!DOCTYPE html");
			out.println("<html>");
			out.println("  <title>Dynamic Example</title>");
			out.println("  <body>");
			out.println("    <h2>Calculator subtract</h2>");
			out.println("    <h2>" + num4 + "</h2>");
			out.println("  </body>");
			out.println("</html>");
		}
		
		if(req.getParameter("deel")!= null) {
			out.println("<!DOCTYPE html");
			out.println("<html>");
			out.println("  <title>Dynamic Example</title>");
			out.println("  <body>");
			out.println("    <h2>Calculator divide</h2>");
			out.println("    <h2>" + num5 + "</h2>");
			out.println("  </body>");
			out.println("</html>");
		}
		
		if(req.getParameter("keer")!= null) {
			out.println("<!DOCTYPE html");
			out.println("<html>");
			out.println("  <title>Dynamic Example</title>");
			out.println("  <body>");
			out.println("    <h2>Calculator multiply</h2>");
			out.println("    <h2>" + num6 + "</h2>");
			out.println("  </body>");
			out.println("</html>");
		}
	}
}
