package com.tc.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/createCookie")
public class CreateCookieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Create a Cookie
		Cookie myNameCookie = new Cookie("myName","Abhishek");
		Cookie myLocationCookie = new Cookie("myLocation","Bangalore");
		myLocationCookie.setMaxAge(7*24*60*60); //Time in sec
		//Send the above Cookie to Browser
		resp.addCookie(myNameCookie);
		resp.addCookie(myLocationCookie);
		
		PrintWriter out = resp.getWriter();
		out.println("Created the Cookie");
	}//End of doGet()
}//End of Class
