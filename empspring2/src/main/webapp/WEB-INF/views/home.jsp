<!DOCTYPE html>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<html>

<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>Page Title</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="bootstrap.min.js"></script>
</head>

<body>

	<div class="container">
		<div class="row navbar navbar-inverse">
			<div class="col-md-2">
				<a href="./validate/getHomePage"><img src="1.png"
					style="width: 50px; height: 50px;"></a>
			</div>

			<div class='col-md-8'>
				<form action='./validate/searchEmployee'>
					<input type='search' name='q'
						placeholder='Enter Employee ID or Name' class='form-control'>
			</div>

			<div class='col-md-1'>
				<button type='submit' class='fa fa-search  border-0'
					style='font-size: 25px; background-color: rgba(255, 255, 255, 0); color: rgba(110, 104, 104, 0.8); position: relative; left: -75px;'></button>
				</form>
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
							<%-- 							<td><%=bean.getName()%></td> --%>
							<td>${bean.name}</td>
						</tr>
						<tr>
							<td>Age</td>
							<td>${bean.age}</td>
						</tr>
						<tr>
							<td>Gender</td>
							<td>${bean.gender}</td>
						</tr>
						<tr>
							<td>DOB</td>
							<td>${bean.dob}</td>
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
							<td>${bean.email}</td>
						</tr>
						<tr>
							<td>Phone Number</td>
							<td>${bean.phone}</td>
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
							<td>${bean.salary}</td>
							<td>Manager ID</td>
							<td>${bean.managerId}</td>
						</tr>
						<tr>
							<td>Joining Date</td>
							<td>${bean.joiningDate}</td>
							<td>Department ID</td>
							<td>${bean.departmentId}</td>
						</tr>
						<tr>
							<td>Designation</td>
							<td>${bean.designation}</td>
							<td>Account Number</td>
							<td>${bean.accountNumber}</td>
						</tr>

					</table>
				</div>

			</div>

		</div>

	</div>

<a href="../webapp2/loginPage">Click</a>
</body>
</html>