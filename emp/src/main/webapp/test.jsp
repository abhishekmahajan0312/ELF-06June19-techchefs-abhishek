<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
	
	<script>
		function go(){
			document.getElementById("multiCollapseExample1").collapse('show');
		}
	</script>
</head>
<body>
	<div class="container">
	
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="#">Active</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#" onclick="go()">Link</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Link</a>
    </li>
    <li class="nav-item">
      <a class="nav-link disabled" href="#">Disabled</a>
    </li>
  </ul>
</nav>
	
		<p>
			<a class="btn btn-primary" data-toggle="collapse"
				href="#multiCollapseExample1" role="button" aria-expanded="false"
				aria-controls="multiCollapseExample1">Toggle first element</a>
			<button class="btn btn-primary" type="button" data-toggle="collapse"
				data-target="#multiCollapseExample2" aria-expanded="false"
				aria-controls="multiCollapseExample2">Toggle second element</button>

		</p>
		<div class="row">
			<div class="col">
				<div class="collapse show multi-collapse" id="multiCollapseExample1">
					<div class="card">
						<div class="card-body">
							<h4 class="text-center border-bottom">EMPLOYEE INFORMATION</h4>
							<br>
							<div class="row">
								<div class="col-md-6">
									<div class="row">
										<div class="col-md-12 form-group">
											<label>ID</label> <input class="form-control" type="number"
												name="id" id="id1" placeholder="Please Enter ID"
												onkeyup="go()" />
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Name</label> <input class="form-control" type="text"
												name="name" placeholder="Please Enter Name" />
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Password</label> <input class="form-control"
												type="password" name="password" id="password"
												placeholder="Please Enter Password" onkeyup="validate()" />
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Confirm Password</label> <input class="form-control"
												type="password" id="cfpassword"
												placeholder="Please Confirm Password" onkeyup="validate()" />
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Age</label> <input class="form-control" type="number"
												name="age" placeholder="Please Enter Age" />
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Gender</label> <select class="form-control"
												name="gender">
												<option>-- select one --</option>
												<option value="male">Male</option>
												<option value="female">Female</option>
											</select>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Salary</label> <input class="form-control" type="text"
												name="salary" placeholder="Please Enter Salary" />
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Phone Number</label> <input class="form-control"
												type="number" name="phone"
												placeholder="Please Enter Phone Number" />
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Joining Date</label> <input class="form-control"
												type="date" name=joining_date
												placeholder="Please Enter Joining Date" />
										</div>
									</div>
								</div>
								<div class="col-md-6">
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Account Number</label> <input class="form-control"
												type="number" name="account_number"
												placeholder="Please Enter Account Number" />
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Email Id</label> <input class="form-control"
												type="email" name="email"
												placeholder="Please Enter Email ID" />
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Designation</label> <input class="form-control"
												type="text" name="designation"
												placeholder="Please Enter Designation" />
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>DOB</label> <input class="form-control" type="date"
												name=dob placeholder="Please Enter DOB" />
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Department ID</label> <input class="form-control"
												type="number" name="department_id"
												placeholder="Please Enter Department ID" />
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Manager ID</label> <input class="form-control"
												type="number" name="manager_id"
												placeholder="Please Enter Manager ID" />
										</div>
									</div>
									<br>
									<div class=" d-flex flex-row mt-2">

										<button type="button"
											class="p-1 offset-1 col-md-5 btn btn-outline-dark"
											style="border-radius: 3px 0 0 3px; border-right: 0">Reset</button>
										<button type="button"
											class="p-1 col-md-5 btn btn-outline-info"
											style="border-radius: 0 3px 3px 0;">Submit</button>

									</div>
								</div>
							</div>
							<!-- </form> -->
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<div class="collapse multi-collapse" id="multiCollapseExample2">
					<div class="card card-body">
						<div class="card-body">
							<h4 class="text-center border-bottom">EMPLOYEE OTHER
								INFORMATION</h4>
							<br>
							<!-- <form action="two.html"> -->
							<div class="row">
								<div class="col-md-4">
									<div class="row">
										<div class="col-md-12 form-group">
											<label>ID</label> <input class="form-control" id="id2"
												type="number" placeholder="Please Enter ID" readonly />
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>PAN Number</label> <input class="form-control"
												name="pan" type="text" placeholder="Please Enter PAN Number" />
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Marital Status</label> <select name="isMarried"
												class="form-control">
												<option>Select</option>
												<option value="true">Yes</option>
												<option value="false">No</option>
											</select>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Blood Group</label> <select name="bloodGroup"
												class="form-control">
												<option value="b+">B+ve</option>
												<option value="b-">B-ve</option>
												<option value="ab+">AB+ve</option>
												<option value="ab-">AB-ve</option>
												<option value="o+">O+ve</option>
												<option value="o-">O-ve</option>
											</select>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Physically Challenged</label> <select
												name="isChallenged" class="form-control">
												<option value="true">Yes</option>
												<option value="false">No</option>
											</select>
										</div>
									</div>

								</div>
								<div class="col-md-4">
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Emergency Contact Number</label> <input
												name="emergencyCN" class="form-control" type="number"
												placeholder="Please Enter Emergency Contact Number" />
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Emergency Contact Name</label> <input
												name="emergencyNM" class="form-control" type="text"
												placeholder="Please Enter Emergency Contact Name" />
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Nationality</label> <select name="nationality"
												class="form-control">
												<option>--select one--</option>
												<option value="india">India</option>
												<option value="japan">Japan</option>
												<option value="china">China</option>
											</select>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Religion</label> <select name="religion"
												class="form-control">
												<option>--select one--</option>
												<option value="hindu">Hindu</option>
												<option value="sikh">Sikh</option>
												<option value="christian">Christian</option>
												<option value="muslim">Muslim</option>
											</select>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Father Name</label> <input name="fname"
												class="form-control" type="text"
												placeholder="Please Enter Father Name" />
										</div>
									</div>

								</div>
								<div class="col-md-4">
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Mother Name</label> <input name="mname"
												class="form-control" type="text"
												placeholder="Please Enter Mother Name" />
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Spouse Name</label> <input name="sname"
												class="form-control" type="text"
												placeholder="Please Enter Spouse Name" />
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Passport Number</label> <input name="passport"
												class="form-control" type="text"
												placeholder="Please Enter Passport Number" />

										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Aadhar Number</label> <input name="adhar"
												class="form-control" type="text"
												placeholder="Please Enter Aadhar Number" />

										</div>
									</div>
									<br>
									<div class=" d-flex flex-row mt-2">

										<button type="submit"
											class="p-1 offset-1 col-md-5 btn btn-outline-dark"
											style="border-radius: 3px 0 0 3px; border-right: 0">Reset</button>
										<button type="submit"
											class="p-1 col-md-5 btn btn-outline-info"
											style="border-radius: 0 3px 3px 0;">Submit</button>

									</div>

								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>