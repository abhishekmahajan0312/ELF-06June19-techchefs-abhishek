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
@WebServlet("/loginpage")
public class LoginPageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie dummyCookie = new Cookie("dummyCookie", "CheckCookiesEnabled");
		resp.addCookie(dummyCookie);
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(false);
		if(session == null) {
			//Invalid Session; Generate Login Page
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
			dispatcher.include(req, resp);
		}
		else {
			EmployeeDao dao = EmployeeDAOFactory.getInstance();
			EmployeeInfoBean bean = dao.getEmployeeInfo(req.getParameter("id"));
			if(bean!=null) {
				req.setAttribute("bean", bean);
			}
			RequestDispatcher dispatcher = req.getRequestDispatcher("/home");
			dispatcher.forward(req, resp);
		}
	
	}//End Of doGet()
}//End of Class
