<!DOCTYPE html>
<%@page import="com.tc.emp.bean.EmployeeInfoBean"%>
<%@page import="java.util.List"%>
<html>

<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Page Title</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src='jquery.min.js'></script>
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
<link rel='stylesheet' href='bootstrap.min.css'>
<script src='bootstrap.min.js'></script>
</head>

<body>
	<%
		List<EmployeeInfoBean> beans = (List<EmployeeInfoBean>) request.getAttribute("emplist");
	%>
	<div class='container'>
		<div class='row navbar navbar-inverse'>
			<div class='col-md-2'>
				<a href='./home'><img src='1.png'
					style='width: 50px; height: 50px;'></a>
			</div>
			<div class='col-md-8'>
				<form action='./search'>
					<input type='search' name='search'
						placeholder='Enter Employee ID or Name' class='form-control'>
			</div>
			<div class='col-md-1'>
				<button type='submit' class='fa fa-search  border-0'
					style='font-size: 25px; background-color: rgba(255, 255, 255, 0); color: rgba(110, 104, 104, 0.8); position: relative; left: -75px;'></button>
				</form>
			</div>
			<div class='col-md-1'>
				<a href='./logout'>Logout</a>
			</div>
		</div>
		<br>
		<div class='row'>
			<div class='col-md-12 card '>
				<table class='table table-striped'>
					<thead>
						<th>Employee Id</th>
						<th>Employee Name</th>
					</thead>
					<tbody>

						<%
							for (EmployeeInfoBean bean : beans) {
						%>
						<tr>
							<td><a href='./getEmployee?id=<%=bean.getId()%>'><%=bean.getId()%></a></td>
							<td><%=bean.getName()%></td>
						</tr>
						<%
							}
						%>

					</tbody>
				</table>
			</div>

		</div>
	</div>
</body>

</html>
