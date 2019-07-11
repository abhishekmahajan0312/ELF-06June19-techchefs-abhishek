package com.tc.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tc.mywebapp.bean.EmployeeInfoBean;
import com.tc.mywebapp.dao.EmployeeDAOFactory;
import com.tc.mywebapp.dao.EmployeeDao;

@WebServlet("/search")
public class EmployeeSearchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idValue = req.getParameter("id");

		//
		EmployeeDao dao = EmployeeDAOFactory.getInstance();
		EmployeeInfoBean bean = dao.getEmployeeInfo(idValue);

		PrintWriter out = resp.getWriter();
		if (bean == null) {
			out.print("<HTML>");
			out.print("<BODY>");
			out.print("<h1><span style=\"color: red;\">Employee Not Found !!</span></h1>");
			out.print("</BODY>");
			out.print("</HTML>");
    
		} else {
			out.print("<HTML>");
			out.print("<BODY>");
			out.print("<h1><span style=\"color: green;\">Employee Found...</span></h1>");
			out.println("<br>Id: " + bean.getId());
			out.println("<br>Name: " + bean.getName());
			out.println("<br>Age: " + bean.getAge());
			out.println("<br>Gender: " + bean.getGender());
			out.println("<br>Salary: " + bean.getSalary());
			out.println("<br>Phone: " + bean.getPhone());
			out.println("<br>Joining Date: " + bean.getJoiningDate());
			out.println("<br>Account Number: " + bean.getAccountNumber());
			out.println("<br>Email: " + bean.getEmail());
			out.println("<br>Designation:" + bean.getDesignation());
			out.println("<br>DOB:" + bean.getDob());
			out.println("<br>Department Id: " + bean.getDepartmentId());
			out.println("<br>Manager Id: " + bean.getManagerId());
			out.print("</BODY>");
			out.print("</HTML>");

		}
	}// End of doGet
}// End of EmployeeSearchServlet
