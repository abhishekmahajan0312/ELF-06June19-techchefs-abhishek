package com.tc.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String currentDateTime = new Date().toString();
		String htmlResponse = "<!DOCTYPE html>" + "<html>" + "<head>" + "<meta charset=\"ISO-8859-1\">"
				+ "<title>My First HTML</title>" + "</head>" + "<body>" + "	<h1>" + "	Current Date and Time is : "
				+ "	<br>" + "	<span style=\"color: red;\">" + currentDateTime + "</span>" + "	</h1>" + "</body>"
				+ "</html>";

		// Send the Above HTML Response to browser
		resp.setContentType("text/html");
		resp.setHeader("Refresh", "1"); // Auto Refresh
		PrintWriter out = resp.getWriter();
		out.println(htmlResponse);

	}// End of doGet()

}// End Of Class
