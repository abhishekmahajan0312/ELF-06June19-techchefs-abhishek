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

		PrintWriter out = resp.getWriter();
		//Validate The Session
		HttpSession session = req.getSession(false);
		if(session == null) {
			//Invalid Session;
			out.println("<h1 style='color:red'>Invalid Session!!! Pls Login</h1>");
			out.println("<br><br>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
			dispatcher.include(req, resp);
		}
		else {
			EmployeeDao dao = EmployeeDAOFactory.getInstance();
			List<EmployeeInfoBean> beans = dao.getAllEmployeeInfoWithRestrictions(req.getParameter("q"));

			out.println("<!DOCTYPE html>                                                                                                                                                         ");
			out.println("<html>                                                                                                                                                                  ");
			out.println("                                                                                                                                                                        ");
			out.println("<head>                                                                                                                                                                  ");
			out.println("    <meta charset='utf-8'>                                                                                                                                              ");
			out.println("    <meta http-equiv='X-UA-Compatible' content='IE=edge'>                                                                                                               ");
			out.println("    <title>Page Title</title>                                                                                                                                           ");
			out.println("    <meta name='viewport' content='width=device-width, initial-scale=1'>                                                                                                ");
			out.println("    <script src='jquery.min.js'></script>                                                                                                                               ");
			out.println("    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>                                                   ");
			out.println("    <link rel='stylesheet' href='bootstrap.min.css'>                                                                                                                    ");
			out.println("    <script src='bootstrap.min.js'></script>                                                                                                                            ");
			out.println("</head>                                                                                                                                                                 ");
			out.println("                                                                                                                                                                        ");
			out.println("<body>                                                                                                                                                                  ");
			out.println("                                                                                                                                                                        ");
			out.println("    <div class='container'>                                                                                                                                             ");
			out.println("        <div class='row navbar navbar-inverse'>                                                                                                                         ");
			out.println("            <div class='col-md-2'>                                                                                                                                      ");
			out.println("                <a href='./home'><img src='1.png' style='width: 50px; height: 50px;'></a>                                                                              ");
			out.println("            </div>                                                                                                                                                      ");
			out.println("            <div class='col-md-8'>                                                                                                                                      ");
			out.println("                <form action='./search'><input type='search' name='search' placeholder='Enter Employee ID or Name'                                                      ");
			out.println("                        class='form-control'>                                                                                                                           ");
			out.println("            </div>                                                                                                                                                      ");
			out.println("            <div class='col-md-1'><button type='submit' class='fa fa-search  border-0'                                                                                  ");
			out.println("                    style='font-size: 25px; background-color:rgba(255,255,255,0); color:rgba(110, 104, 104, 0.8); position: relative;  left: -75px;'></button>          ");
			out.println("                </form>                                                                                                                                                 ");
			out.println("            </div>                                                                                                                                                      ");
			out.println("            <div class='col-md-1'>                                                                                                                                      ");
			out.println("                <a href='./logout'>Logout</a>                                                                                                                           ");
			out.println("            </div>                                                                                                                                                      ");
			out.println("        </div>                                                                                                                                                          ");
			out.println("        <br>                                                                                                                                                            ");
			out.println("        <div class='row'>                                                                                                                                               ");
			out.println("            <div class='col-md-12 card '>                                                                                                                               ");
			out.println("                <table class='table table-striped'>                                                                                                                     ");
			out.println("                    <thead>                                                                                                                                             ");
			out.println("                        <th>Employee Id</th>                                                                                                                            ");
			out.println("                        <th>Employee Name</th>                                                                                                                          ");
			out.println("                    </thead>                                                                                                                                            ");
			out.println("                    <tbody>                                                                                                                                             ");
			
			for (EmployeeInfoBean employeeInfoBean : beans) {
				out.println("                            <tr><td><a href='./getEmployee?id="+employeeInfoBean.getId()+"'>"+employeeInfoBean.getId()+"</a></td>                                                                                                        ");
				out.println("                            <td>"+employeeInfoBean.getName()+"</td></tr>                                                                                                                                   ");
				
			}
			
			out.println("                    </tbody>                                                                                                                                            ");
			out.println("                </table>                                                                                                                                                ");
			out.println("            </div>                                                                                                                                                      ");
			out.println("                                                                                                                                                                        ");
			out.println("        </div>                                                                                                                                                          ");
			out.println("</body>                                                                                                                                                                 ");
			out.println("                                                                                                                                                                        ");
			out.println("</html>                                                                                                                                                                 ");

		}
			
	}
}