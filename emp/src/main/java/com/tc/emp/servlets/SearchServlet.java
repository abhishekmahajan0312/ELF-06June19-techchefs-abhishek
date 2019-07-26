package com.tc.emp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.tc.emp.util.HibernateUtil;

import lombok.extern.java.Log;

@Log
@WebServlet("/search")
public class SearchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Validate The Session
		HttpSession session = req.getSession(false);
		if(session == null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp?msg=Invalid Session!!! Pls Login");
			dispatcher.include(req, resp);
		}
		else {
			EmployeeDao dao = EmployeeDAOFactory.getInstance();
			List<EmployeeInfoBean> beans = dao.getAllEmployeeInfoWithRestrictions(req.getParameter("q"));
			req.setAttribute("emplist", beans);
			req.getRequestDispatcher("SearchEmployee.jsp").forward(req, resp);
			
		}
			
	}
}