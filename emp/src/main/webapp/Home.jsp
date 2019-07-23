
<!DOCTYPE html>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.tc.emp.bean.EmployeeInfoBean"%>

<html>

<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Page Title</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="bootstrap.min.css">
<script src="bootstrap.min.js"></script>
</head>

<body>

	<%
		try {
			/* PrintWriter out = resp.getWriter();
			if (session == null) {
				// Invalid Session;
				out.println("<h1 style='color:red'>Invalid Session!!! Pls Login</h1>");
				out.println("<br><br>");
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
				dispatcher.include(req, resp);
			} else { */

			EmployeeInfoBean bean = (EmployeeInfoBean) request.getAttribute("bean");
			/* if (bean == null) {
				bean = (EmployeeInfoBean) session.getAttribute("bean");
			
			} */
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date joiningDate;
			Date dob;

			joiningDate = format.parse(bean.getJoiningDate().toString());
			dob = format.parse(bean.getDob().toString());
	%>


	<div class="container">
		<div class="row navbar navbar-inverse">
			<div class="col-md-2">
				<a href="./home"><img src="1.jpg"
					style="width: 50px; height: 50px;"></a>
			</div>
			<div class="col-md-8">
				<input type="search" class="form-control">
			</div>
			<div class="col-md-1">
				<i class="fa fa-search"
					style="font-size: 25px; color: rgba(110, 104, 104, 0.8); position: relative; left: -60px;"></i>
			</div>
			<div class="col-md-1">
				<a href="./logout">Logout</a>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-5 card ">

				<div class="card-body">
					<h5>Personal Details</h5>
					<hr>
					<table class="table table-striped">
						<tr>
							<td>Name</td>
							<td><%=bean.getName()%></td>
						</tr>
						<tr>
							<td>Age</td>
							<td><%=bean.getAge()%></td>
						</tr>
						<tr>
							<td>Gender</td>
							<td><%=bean.getGender()%></td>
						</tr>
						<tr>
							<td>DOB</td>
							<td><%=dob%></td>
						</tr>

					</table>
				</div>

			</div>
			<div class="offset-2 col-md-5 card ">
				<div class="card-body">
					<h5>Contact Details</h5>
					<hr>
					<table class="table table-striped">
						<tr>
							<td>Email</td>
							<td><%=bean.getEmail()%></td>
						</tr>
						<tr>
							<td>Phone Number</td>
							<td><%=bean.getPhone()%></td>
						</tr>
						<tr>
							<td>Address 1</td>
							<td></td>
						</tr>
						<tr>
							<td>Address 2</td>
							<td></td>
						</tr>

					</table>
				</div>
			</div>
		</div>
		<br> <br>
		<div class="row">
			<div class="col-md-12 card ">

				<div class="card-body">
					<h5>Professional Details</h5>
					<hr>
					<table class="table table-striped">
						<tr>
							<td>Salary</td>
							<td><%=bean.getSalary()%></td>
							<td>Manager ID</td>
							<td><%=bean.getManagerId()%></td>
						</tr>
						<tr>
							<td>Joining Date</td>
							<td><%=joiningDate%></td>
							<td>Department ID</td>
							<td><%=bean.getDepartmentId()%></td>
						</tr>
						<tr>
							<td>Designation</td>
							<td><%=bean.getDesignation()%></td>
							<td>Account Number</td>
							<td><%=bean.getAccountNumber()%></td>
						</tr>

					</table>
				</div>

			</div>

		</div>

	</div>

	<%
		/* } */
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	%>
</body>
</html>