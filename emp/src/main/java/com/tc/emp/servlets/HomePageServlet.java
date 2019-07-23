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

//@WebServlet("/home")
public class HomePageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = req.getSession(false);
			
			
			PrintWriter out = resp.getWriter();
			if (session == null) {
				// Invalid Session;
				out.println("<h1 style='color:red'>Invalid Session!!! Pls Login</h1>");
				out.println("<br><br>");
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
				dispatcher.include(req, resp);
			} else {

				EmployeeInfoBean bean = (EmployeeInfoBean) req.getAttribute("bean");
				if (bean == null) {
					bean = (EmployeeInfoBean) session.getAttribute("bean");

				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date joiningDate;
				Date dob;

				joiningDate = format.parse(bean.getJoiningDate().toString());
				dob = format.parse(bean.getDob().toString());

				out.println(
						"<!DOCTYPE html>                                                                                                         ");
				out.println(
						"<html>                                                                                                                  ");
				out.println(
						"<head>                                                                                                                  ");
				out.println(
						"    <meta charset='utf-8'>                                                                                              ");
				out.println(
						"    <meta http-equiv='X-UA-Compatible' content='IE=edge'>                                                               ");
				out.println(
						"    <title>Page Title</title>                                                                                           ");
				out.println(
						"    <meta name='viewport' content='width=device-width, initial-scale=1'>                                                ");
				out.println(
						"    <script src=\"jquery.min.js\"></script>                                                                               ");
				out.println(
						"    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">   ");
				out.println(
						"    <link rel=\"stylesheet\" href=\"bootstrap.min.css\">                                                                    ");
				out.println(
						"    <script src=\"bootstrap.min.js\"></script>                                                                            ");
				out.println(
						"</head>                                                                                                                 ");
				out.println(
						"<body>                                                                                                                  ");
				out.println(
						"    <div class=\"container\">                                                                                             ");
				out.println(
						"        <div class=\"row navbar navbar-inverse\">                                                                         ");
				out.println(
						"            <div class=\"col-md-2\">                                                                                      ");
				out.println(
						"                <a href=\"./home\"><img src=\"1.png\" style=\"width: 50px; height: 50px;\"></a>                               ");
				out.println(
						"            </div>                                                                                                      ");
				out.println(
						"            <div class='col-md-8'><form action='./search' method='GET'>                                                                                      ");
				out.println(
						"                <input type='search' name='q' placeholder='Enter Employee ID or Name' class='form-control'>                                                              ");
				out.println(
						"            </div>                                                                                                      ");
				out.println(
						"            <div class='col-md-1'><button type='submit' class='fa fa-search  border-0'                                                               ");
				out.println(
						"                    style='font-size: 25px; background-color:rgba(255,255,255,0); color:rgba(110, 104, 104, 0.8); position: relative;  left: -75px;'></button>     ");
				out.println(
						"            </form></div>                                                                                                      ");
				out.println(
						"            <div class='col-md-1'>                                                                                      ");
				out.println(
						"                <a class='btn btn-primary' href='./logout'>Logout</a>                                                                           ");
				out.println(
						"            </div>                                                                                                      ");
				out.println(
						"        </div>                                                                                                          ");
				out.println(
						"        <br>                                                                                                            ");
				out.println(
						"        <div class='row'>                                                                                               ");
				out.println(
						"            <div class='col-md-5 card '>                                                                                ");
				out.println(
						"                                                                                                                        ");
				out.println(
						"                <div class='card-body'>                                                                                 ");
				out.println(
						"                    <h5>                                                                                                ");
				out.println(
						"                        Personal Details                                                                                ");
				out.println(
						"                    </h5>                                                                                               ");
				out.println(
						"                    <hr>                                                                                                ");
				out.println(
						"                    <table class='table table-striped'>                                                                 ");
				out.println(
						"                        <tr>                                                                                            ");
				out.println(
						"                            <td>Name</td>                                                                               ");
				out.println("                            <td>" + bean.getName()
						+ "</td>                                                                                   ");
				out.println(
						"                        </tr>                                                                                           ");
				out.println(
						"                        <tr>                                                                                            ");
				out.println(
						"                            <td>Age</td>                                                                                ");
				out.println("                            <td>" + bean.getAge()
						+ "</td>                                                                                   ");
				out.println(
						"                        </tr>                                                                                           ");
				out.println(
						"                        <tr>                                                                                            ");
				out.println(
						"                            <td>Gender</td>                                                                             ");
				out.println("                            <td>" + bean.getGender()
						+ "</td>                                                                                   ");
				out.println(
						"                        </tr>                                                                                           ");
				out.println(
						"                        <tr>                                                                                            ");
				out.println(
						"                            <td>DOB</td>                                                                                ");
				out.println("                            <td>" + dob
						+ "</td>                                                                                   ");
				out.println(
						"                        </tr>                                                                                           ");
				out.println(
						"                                                                                                                        ");
				out.println(
						"                    </table>                                                                                            ");
				out.println(
						"                </div>                                                                                                  ");
				out.println(
						"                                                                                                                        ");
				out.println(
						"            </div>                                                                                                      ");
				out.println(
						"            <div class='offset-2 col-md-5 card '>                                                                       ");
				out.println(
						"                <div class='card-body'>                                                                                 ");
				out.println(
						"                    <h5>                                                                                                ");
				out.println(
						"                        Contact Details                                                                                 ");
				out.println(
						"                    </h5>                                                                                               ");
				out.println(
						"                    <hr>                                                                                                ");
				out.println(
						"                    <table class='table table-striped'>                                                                 ");
				out.println(
						"                        <tr>                                                                                            ");
				out.println(
						"                            <td>Email</td>                                                                              ");
				out.println("                            <td>" + bean.getEmail()
						+ "</td>                                                                                   ");
				out.println(
						"                        </tr>                                                                                           ");
				out.println(
						"                        <tr>                                                                                            ");
				out.println(
						"                            <td>Phone Number</td>                                                                       ");
				out.println("                            <td>" + bean.getPhone()
						+ "</td>                                                                                   ");
				out.println(
						"                        </tr>                                                                                           ");
				out.println(
						"                        <tr>                                                                                            ");
				out.println(
						"                            <td>Address 1</td>                                                                          ");
				out.println(
						"                            <td></td>                                                                                   ");
				out.println(
						"                        </tr>                                                                                           ");
				out.println(
						"                        <tr>                                                                                            ");
				out.println(
						"                            <td>Address 2</td>                                                                          ");
				out.println(
						"                            <td></td>                                                                                   ");
				out.println(
						"                        </tr>                                                                                           ");
				out.println(
						"                                                                                                                        ");
				out.println(
						"                    </table>                                                                                            ");
				out.println(
						"                </div>                                                                                                  ");
				out.println(
						"            </div>                                                                                                      ");
				out.println(
						"        </div>                                                                                                          ");
				out.println(
						"        <br>                                                                                                            ");
				out.println(
						"        <br>                                                                                                            ");
				out.println(
						"        <div class='row'>                                                                                               ");
				out.println(
						"            <div class='col-md-12 card '>                                                                               ");
				out.println(
						"                                                                                                                        ");
				out.println(
						"                <div class='card-body'>                                                                                 ");
				out.println(
						"                    <h5>                                                                                                ");
				out.println(
						"                        Professional Details                                                                            ");
				out.println(
						"                    </h5>                                                                                               ");
				out.println(
						"                    <hr>                                                                                                ");
				out.println(
						"                    <table class='table table-striped'>                                                                 ");
				out.println(
						"                        <tr>                                                                                            ");
				out.println(
						"                            <td>Salary</td>                                                                             ");
				out.println("                            <td>" + bean.getSalary()
						+ "</td>                                                                                   ");
				out.println(
						"                            <td>Manager ID</td>                                                                         ");
				out.println("                            <td>" + bean.getManagerId()
						+ "</td>                                                                                   ");
				out.println(
						"                        </tr>                                                                                           ");
				out.println(
						"                        <tr>                                                                                            ");
				out.println(
						"                            <td>Joining Date</td>                                                                       ");
				out.println("                            <td>" + joiningDate
						+ "</td>                                                                                   ");
				out.println(
						"                            <td>Department ID</td>                                                                      ");
				out.println("                            <td>" + bean.getDepartmentId()
						+ "</td>                                                                                   ");
				out.println(
						"                        </tr>                                                                                           ");
				out.println(
						"                        <tr>                                                                                            ");
				out.println(
						"                            <td>Designation</td>                                                                        ");
				out.println("                            <td>" + bean.getDesignation()
						+ "</td>                                                                                   ");
				out.println(
						"                            <td>Account Number</td>                                                                     ");
				out.println("                            <td>" + bean.getAccountNumber()
						+ "</td>                                                                                   ");
				out.println(
						"                        </tr>                                                                                           ");
				out.println(
						"                                                                                                                        ");
				out.println(
						"                    </table>                                                                                            ");
				out.println(
						"                </div>                                                                                                  ");
				out.println(
						"                                                                                                                        ");
				out.println(
						"            </div>                                                                                                      ");
				out.println(
						"                                                                                                                        ");
				out.println(
						"        </div>                                                                                                          ");
				out.println(
						"                                                                                                                        ");
				out.println(
						"    </div>                                                                                                              ");
				out.println(
						"</body>                                                                                                                 ");
				out.println(
						"                                                                                                                        ");
				out.println(
						"</html>                                                                                                                 ");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}