package com.tc.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readCookie")
public class ReadCookieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Get the Cookies from request
		Cookie[] receivedCookies = req.getCookies();

		PrintWriter out = resp.getWriter();
		if (receivedCookies == null) {
			out.println("Cookies are Not Present");
		}
		else {
			out.print("Cookies are Present");
			for (Cookie rcvdCookie : receivedCookies) {
				out.println("Cookie Name: "+rcvdCookie.getName());
				out.println("Cookie Value: "+rcvdCookie.getValue());
			}//End Of for loop
		}//End of If-Else
	}// End of doGet()
}// End of Class
