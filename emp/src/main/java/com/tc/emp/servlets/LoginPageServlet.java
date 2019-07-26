package com.tc.emp.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tc.emp.bean.EmployeeInfoBean;
@WebServlet("/loginpage")
public class LoginPageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie dummyCookie = new Cookie("dummyCookie", "CheckCookiesEnabled");
		resp.addCookie(dummyCookie);
		HttpSession session = req.getSession(false);
		
		if(session == null || session.getAttribute("data")==null) {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("/home").forward(req, resp);
		}
	}//End Of doGet()
}//End of Class
