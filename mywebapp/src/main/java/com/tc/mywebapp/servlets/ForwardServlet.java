package com.tc.mywebapp.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tc.mywebapp.bean.EmployeeInfoBean;

@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		EmployeeInfoBean empInfo = new EmployeeInfoBean();
		empInfo.setId(1234);
		empInfo.setName("Abhishek");
		empInfo.setPhone(1234567890l);
		empInfo.setEmail("abc@gmail.com");
		
		//Pass the object to Employee Search Servlet
		//req.setAttribute("info", empInfo);
		
		ServletContext ctx = getServletContext();
		ctx.setAttribute("info",empInfo);
		
		String url = "search?id=1";
//		String url = "http://www.google.com";
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
	}//End Of doGet
}//End of ForwardServlet


