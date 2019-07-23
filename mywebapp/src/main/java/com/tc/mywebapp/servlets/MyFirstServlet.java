package com.tc.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tc.mywebapp.bean.EmployeeInfoBean;

public class MyFirstServlet extends HttpServlet {

	public MyFirstServlet() {
//		this(20);
		System.out.println("Inside MyFirst Servlet 1");
		{
			System.out.println("222");
		}
		System.out.println("333");
	}
//	public MyFirstServlet(int i) {				//With only this constructor it will not instantiate at runtime
//		// TODO Auto-generated constructor stub
//		this("");
//		System.out.println("Inside MyFirst Servlet 2");
//	}
//	public MyFirstServlet(String s) {
//		System.out.println("Inside MyFirst Servlet 3");
//	}

//	public static void main(String[] args) { //This will never execute
//		System.out.println("Hello World");
//	}

	@Override
	protected synchronized void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		ServletContext ctx = getServletContext();
		String movieName = ctx.getInitParameter("movie");

		ServletConfig cfg = getServletConfig();
		String actorName = cfg.getInitParameter("actor");

		String currentDateTime = new Date().toString();

		// Get Query String Information
//		String httpMethod = req.getMethod();
//		String protocol = req.getProtocol();
//		String requestUrl = req.getRequestURL().toString();
//		System.out.println("HTTP Method::: "+httpMethod);
//		System.out.println("Protocol::: "+protocol);
//		System.out.println("Request URL::: "+requestUrl);
		String fnameValue = req.getParameter("fname");
		String lnameValue = req.getParameter("lname");

		String htmlResponse = "<!DOCTYPE html>" + "<html>" + "<head>" + "<meta charset=\"ISO-8859-1\">"
				+ "<title>My First HTML</title>" + "</head>" + "<body>" + "	<h1>" + "	Current Date and Time is : "
				+ "	<br>" + "	<span style=\"color: red;\">" + currentDateTime + "</span><br><br>" + "First Name : "
				+ fnameValue + "<br> Last Name : " + lnameValue + "<br> Movie Name : " + movieName
				+ "<br> Actor Name : " + actorName + "	</h1>" + "</body>" + "</html>";

		// Send the Above HTML Response to browser
		resp.setContentType("text/html");
//		resp.setHeader("Refresh", "1"); // Auto Refresh
		PrintWriter out = resp.getWriter();
		out.println(htmlResponse);
//		out.println(fnameValue.equals("ABc"));   

		// Get the object from Forward Servlet
				
//		EmployeeInfoBean empInfo = (EmployeeInfoBean) req.getAttribute("info");
		EmployeeInfoBean empInfo = (EmployeeInfoBean) ctx.getAttribute("info");
		if (empInfo == null) {
			out.print("<HTML>");
			out.print("<BODY>");
			out.print("<h1><span style=\"color: red;\">EmployeeInfoBean Object Not Found !!</span></h1>");
			out.print("</BODY>");
			out.print("</HTML>");
		} else {
			out.print("<HTML>");
			out.print("<BODY>");
			out.print("<h1><span style=\"color: green;\">EmployeeInfoObject Found...</span></h1>");
			out.println("<br>Id: " + empInfo.getId());
			out.println("<br>Name: " + empInfo.getName());
			out.println("<br>Phone: " + empInfo.getPhone());
			out.println("<br>Email: " + empInfo.getEmail());
			out.print("</BODY>");
			out.print("</HTML>");
		}

	}// End of doGet()

}// End Of Class
