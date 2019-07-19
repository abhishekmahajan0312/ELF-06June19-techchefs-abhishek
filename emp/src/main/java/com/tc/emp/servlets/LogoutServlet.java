package com.tc.emp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tc.emp.bean.EmployeeInfoBean;
import com.tc.emp.dao.EmployeeDAOFactory;
import com.tc.emp.dao.EmployeeDao;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		getServletContext().removeAttribute("bean");
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();

			PrintWriter out = resp.getWriter();

			out.println("<h1 style='color:green'>Thanks For Visiting !!!</h1>");
			out.println("<br><br>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
			dispatcher.include(req, resp);
		}
	}
}
