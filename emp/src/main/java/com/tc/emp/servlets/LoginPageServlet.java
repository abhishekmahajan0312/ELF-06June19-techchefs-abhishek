package com.tc.emp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tc.emp.bean.EmployeeInfoBean;
import com.tc.emp.dao.EmployeeDAOFactory;
import com.tc.emp.dao.EmployeeDao;
@WebServlet("/myapp/loginpage")
public class LoginPageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie dummyCookie = new Cookie("dummyCookie", "CheckCookiesEnabled");
		resp.addCookie(dummyCookie);
		HttpSession session = req.getSession(false);
		System.out.println(req.getRequestURI());
		if(session == null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("./myapp/loginjsp");
			
			dispatcher.forward(req, resp);
		}
		else {
			EmployeeInfoBean bean = (EmployeeInfoBean)session.getAttribute("data");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/home");
			dispatcher.forward(req, resp);
		}
	
	}//End Of doGet()
}//End of Class
