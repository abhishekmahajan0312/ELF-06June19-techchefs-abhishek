<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script>
	function go() {
		document.getElementById("id2").value = document.getElementById("id1").value;
	}
	
	function validate(){
		if(document.getElementById("password") !==  document.getElementById("cfpassword")){
			
		}
		
	}
</script>

</head>

<body>

	<div class="container">
		<h2>EMPLOYEE REGISTRATION</h2>
		<p>Click on the panel to EXPAND</p>
		<form action="./createEmployee" method="post">
			<div class="panel-group">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" href="#collapse1">Employee
								Information</a>
						</h4>
					</div>
					<div id="collapse1" class="panel-collapse collapse"
						style="background-color: lightgoldenrodyellow">
						<!-- <div class="row">
              <div class="col-md-12 card"
                  > -->
						<div class="card-body">
							<h4 class="text-center border-bottom">EMPLOYEE INFORMATION</h4>
							<br>
							<div class="row">
								<div class="col-md-6">
									<div class="row">
										<div class="col-md-12 form-group">
											<label>ID</label> <input class="form-control" type="number"
												name="id" id="id1" placeholder="Please Enter ID" onkeyup="go()" />
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
												placeholder="Please Enter Password" onkeyup="validate()"/>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Confirm Password</label> <input class="form-control"
												type="password" id="cfpassword"
												placeholder="Please Confirm Password" onkeyup="validate()"/>
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
						<!-- </div>
          </div> -->
						<div class="panel-footer">Footer</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" href="#collapse2">Employee Other
								Information</a>
						</h4>
					</div>
					<div id="collapse2" class="panel-collapse collapse "
						style="background-color: lightgoldenrodyellow">
						<!-- <div class="row">
              <div class="col-md-12 card"
                  > -->
						<div class="card-body">
							<h4 class="text-center border-bottom">EMPLOYEE OTHER
								INFORMATION</h4>
							<br>
							<!-- <form action="two.html"> -->
							<div class="row">
								<div class="col-md-4">
									<div class="row">
										<div class="col-md-12 form-group">
											<label>ID</label> <input class="form-control" id="id2" name="otherInfo.id"
												type="number" placeholder="Please Enter ID" readonly />
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>PAN Number</label> <input class="form-control"
												name="otherInfo.pan" type="text" placeholder="Please Enter PAN Number" />
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Marital Status</label> <select name="otherInfo.isMarried"
												class="form-control">
												<option>Select</option>
												<option value="true">Yes</option>
												<option value="false">No</option>
											</select>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Blood Group</label> <select name="otherInfo.bloodGrp"
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
												name="otherInfo.isChallenged" class="form-control">
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
												name="otherInfo.emergencyCN" class="form-control" type="number"
												placeholder="Please Enter Emergency Contact Number" />
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Emergency Contact Name</label> <input
												name="otherInfo.emergencyCP" class="form-control" type="text"
												placeholder="Please Enter Emergency Contact Name" />
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Nationality</label> <select name="otherInfo.nationality"
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
											<label>Religion</label> <select name="otherInfo.religion"
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
											<label>Father Name</label> <input name="otherInfo.fatherNM"
												class="form-control" type="text"
												placeholder="Please Enter Father Name" />
										</div>
									</div>

								</div>
								<div class="col-md-4">
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Mother Name</label> <input name="otherInfo.motherNM"
												class="form-control" type="text"
												placeholder="Please Enter Mother Name" />
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Spouse Name</label> <input name="otherInfo.spouseNM"
												class="form-control" type="text"
												placeholder="Please Enter Spouse Name" />
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Passport Number</label> <input name="otherInfo.passport"
												class="form-control" type="text"
												placeholder="Please Enter Passport Number" />

										</div>
									</div>
									<div class="row">
										<div class="col-md-12 form-group">
											<label>Aadhar Number</label> <input name="otherInfo.adhar"
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
						<!-- </div>
          </div> -->
						<div class="panel-footer">Footer</div>
					</div>
				</div>
			</div>
		</form>
	</div>