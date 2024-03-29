package com.tc.emp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Check Cookies are Disabled

		if (req.getCookies() == null) {
			req.getRequestDispatcher("cookiesdisabled.html").include(req, resp);
			return;
		}
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String url=null; 
		EmployeeDao dao = EmployeeDAOFactory.getInstance();
		EmployeeInfoBean empInf = dao.getEmployeeInfo(id);
		if (empInf != null && empInf.getPassword().equals(password)) {
			HttpSession session = req.getSession(true);
			session.setAttribute("data", empInf);
			Cookie cookie = new Cookie("JSESSIONID", session.getId());
			cookie.setMaxAge(7*24*60*60);
			resp.addCookie(cookie);
			url = "./home";
		} else
		{
			url = "login.jsp?msg=Invalid Username and Password!!!";
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
	}

}
