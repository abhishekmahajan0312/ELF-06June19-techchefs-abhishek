package com.tc.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tc.mywebapp.bean.DepartmentInfoBean;
import com.tc.mywebapp.bean.EmployeeInfoBean;
import com.tc.mywebapp.dao.DepartmentDAOFactory;
import com.tc.mywebapp.dao.DepartmentDao;
import com.tc.mywebapp.dao.EmployeeDAOFactory;
import com.tc.mywebapp.dao.EmployeeDao;
import com.tc.mywebapp.util.HibernateUtil;

@WebServlet("/createDepartment")
public class CreateDepartmentServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		DepartmentInfoBean deptInf = new DepartmentInfoBean();
		deptInf.setDepartmentID(Integer.parseInt(req.getParameter("department_id")));
		deptInf.setDepartmentName(req.getParameter("department_name"));
		
		
		DepartmentDao dao = DepartmentDAOFactory.getInstance();

		boolean result = dao.createDepartmentInfo(deptInf);
		if (!result) {
			out.print("<HTML>");
			out.print("<BODY>");
			out.print("<h1><span style=\"color: red;\">Department Not Added Successfully !!</span></h1>");
			out.print("</BODY>");
			out.print("</HTML>");

		} else {
			out.print("<HTML>");
			out.print("<BODY>");
			out.print("<h1><span style=\"color: green;\">Department Added Successfully...</span></h1>");
			out.print("</BODY>");
			out.print("</HTML>");

		}

	}
}
