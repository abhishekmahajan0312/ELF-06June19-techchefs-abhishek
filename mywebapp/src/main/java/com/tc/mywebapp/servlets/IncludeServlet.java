package com.tc.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/include")
public class IncludeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher dispatcher = null;
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("111111111111111111111111111111");
		out.println("<br>");
		dispatcher = req.getRequestDispatcher("index.html");
		dispatcher.include(req, resp);
		out.println("<br>");
		
		out.println("222222222222222222222222222222");
		out.println("<br>");
		dispatcher = req.getRequestDispatcher("currentDate?fname=Abhishek&lname=M");
		dispatcher.include(req, resp);
		out.println("<br>");
		
		out.println("333333333333333333333333333333");
		out.println("<br>");
		dispatcher = req.getRequestDispatcher("search?id=1");
		dispatcher.include(req, resp);
		out.println("<br>");
		
		out.println("444444444444444444444444444444");
		
		
		
	}//End Of doGet()
	
}//End of Class
