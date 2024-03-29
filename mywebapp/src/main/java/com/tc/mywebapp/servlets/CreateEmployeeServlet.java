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

import com.tc.mywebapp.bean.EmployeeInfoBean;
import com.tc.mywebapp.dao.EmployeeDAOFactory;
import com.tc.mywebapp.dao.EmployeeDao;
import com.tc.mywebapp.util.HibernateUtil;

@WebServlet("/createEmployee")
public class CreateEmployeeServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		try {
			EmployeeInfoBean empInf = new EmployeeInfoBean();
			empInf.setId(Integer.parseInt(req.getParameter("id")));
			empInf.setName(req.getParameter("name"));
			empInf.setAge(Integer.parseInt(req.getParameter("age")));
			empInf.setGender(req.getParameter("gender"));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date;

			date = format.parse(req.getParameter("joining_date"));

			empInf.setSalary(Double.parseDouble(req.getParameter("salary")));
			empInf.setPhone(Long.parseLong(req.getParameter("phone")));
			empInf.setJoiningDate(date);
			empInf.setAccountNumber(Long.parseLong(req.getParameter("account_number")));
			empInf.setEmail(req.getParameter("email"));
			empInf.setDesignation(req.getParameter("designation"));
			date = format.parse(req.getParameter("dob"));

			empInf.setDob(date);
			empInf.setDepartmentId(Integer.parseInt(req.getParameter("department_id")));
			empInf.setManagerId(Integer.parseInt(req.getParameter("manager_id")));

			
			EmployeeDao dao = EmployeeDAOFactory.getInstance();

			boolean result = dao.createEmployeeInfo(empInf);
			if (!result) {
				out.print("<HTML>");
				out.print("<BODY>");
				out.print("<h1><span style=\"color: red;\">Employee Not Added Successfully !!</span></h1>");
				out.print("</BODY>");
				out.print("</HTML>");

			} else {
				out.print("<HTML>");
				out.print("<BODY>");
				out.print("<h1><span style=\"color: green;\">Employee Added Successfully...</span></h1>");
				out.print("</BODY>");
				out.print("</HTML>");

			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			out.println(e.toString());
		}

	}
}
