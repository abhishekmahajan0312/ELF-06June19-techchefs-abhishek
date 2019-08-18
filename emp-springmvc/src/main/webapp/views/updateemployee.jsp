
<%@page import="com.tc.empspringmvc.beans.EmployeeExperienceInfoBean"%>
<%@page import="com.tc.empspringmvc.beans.EmployeeEducationInfoBean"%>
<%@page import="com.tc.empspringmvc.beans.EmployeeAddressInfoBean"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.tc.empspringmvc.beans.EmployeeInfoBean"%>
<%
	EmployeeInfoBean bean = (EmployeeInfoBean) session.getAttribute("bean");
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	String jd = formatter.format(bean.getJoiningDate());
	String dob = formatter.format(bean.getDob());
	EmployeeInfoBean mngrId = bean.getMngrId();
	String managerId="";
	if(mngrId!=null){
		managerId=Integer.toString(mngrId.getId());
	}
%>
<!DOCTYPE html>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script>
	/* function go() {
		document.getElementById("id2").value = document.getElementById("id1").value;
	}*/

	function validate() {
		if (document.getElementById("password") !== document
				.getElementById("cfpassword")) {

		}

	}
</script>
<style>
.form1 {
	background-color: rgba(100, 150, 200, 0.5);
}
</style>
</head>

<body>

	<div class="container">
		<div class="row">
			<div class="col-md-12 text-center">
				<h2 class="text-center">EMPLOYEE REGISTRATION</h2>
			</div>
		</div>
		<form action="./updateEmployee" method="post">

			<div class="row ">
				<div class="col-md-8 offset-2 card form1">
					<div class="card-body">
						<h4 class="text-center border-bottom">EMPLOYEE INFORMATION</h4>
						<br>
						<div class="row">
							<div class="col-md-6">
								<div class="row">
									<div class="col-md-12 form-group">
										<label>ID</label> <input readonly readonly
											class="form-control" type="number" required name="id"
											id="id1" value='${bean.id}' placeholder="Please Enter ID" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<label>Name</label> <input readonly readonly
											class="form-control" type="text" name="name"
											value='${bean.name}' placeholder="Please Enter Name" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<label>Password</label> <input readonly readonly
											class="form-control" type="password" name="password"
											id="password" placeholder="Please Enter Password"
											value='${bean.password}' onkeyup="validate()" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<label>Confirm Password</label> <input readonly readonly
											class="form-control" type="password" id="cfpassword"
											placeholder="Please Confirm Password" onkeyup="validate()" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<label>Age</label> <input readonly readonly
											class="form-control" type="number" name="age"
											value='${bean.age}' placeholder="Please Enter Age" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<label>Gender</label> <select disabled class="form-control"
											id="gender" name="gender">
											<option>-- select one --</option>
											<%
												if (bean.getGender().equalsIgnoreCase("male")) {
											%>
											<option selected>Male</option>
											<option>Female</option>
											<%
												} else {
											%>
											<option>Male</option>
											<option selected>Female</option>
											<%
												}
											%>
										</select>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<label>Salary</label> <input readonly readonly
											class="form-control" type="text" name="salary"
											value='${bean.salary}' placeholder="Please Enter Salary" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<label>Phone Number</label> <input readonly readonly
											class="form-control" type="number" name="phone"
											value='${bean.phone}' placeholder="Please Enter Phone Number" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<label>Joining Date</label> <input readonly readonly
											class="form-control" type="date" name="joiningDate"
											<%-- value='${bean.joiningDate.toString().substring(0,bean.joiningDate.toString().indexOf(" "))}' --%>
											value="<%=jd%>"
											placeholder="Please Enter Joining Date" />
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="row">
									<div class="col-md-12 form-group">
										<label>Account Number</label> <input readonly readonly
											class="form-control" type="number" name="accountNumber"
											value='${bean.accountNumber}'
											placeholder="Please Enter Account Number" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<label>Email Id</label> <input readonly readonly
											class="form-control" type="email" name="email"
											value='${bean.email}' placeholder="Please Enter Email ID" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<label>Designation</label> <input readonly readonly
											class="form-control" type="text" name="designation"
											value='${bean.designation}'
											placeholder="Please Enter Designation" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<label>DOB</label> <input readonly readonly
											class="form-control" type="date" name=dob value="<%=dob%>"
											placeholder="Please Enter DOB" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<label>Department ID</label> <input readonly readonly
											class="form-control" type="number" name="departmentId"
											value='${bean.departmentId}'
											placeholder="Please Enter Department ID" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<label>Manager ID</label> <input readonly readonly
											class="form-control" type="number" name="managerId"
											value='<%=managerId%>'
											placeholder="Please Enter Manager ID" />
									</div>
								</div>
								<br>
							</div>
						</div>
					</div>
				</div>
			</div>
			<br> <br>

			<div class="row">
				<div class="col-md-8 offset-2 card form1">
					<div class="card-body">
						<h4 class="text-center border-bottom">EMPLOYEE OTHER
							INFORMATION</h4>
						<br>
						<div class="row">
							<div class="col-md-4">

								<div class="row">
									<div class="col-md-12 form-group">
										<label>PAN Number</label> <input readonly readonly
											class="form-control" name="otherInfo.pan" type="text"
											value="${bean.otherInfo.pan}"
											placeholder="Please Enter PAN Number" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<label>Marital Status</label> <select
											name="otherInfo.isMarried" class="form-control">
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
											name="otherInfo.emergencyCN" class="form-control"
											type="number"
											placeholder="Please Enter Emergency Contact Number"
											value="${bean.otherInfo.emergencyCN}" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<label>Emergency Contact Name</label> <input
											name="otherInfo.emergencyCP" class="form-control" type="text"
											placeholder="Please Enter Emergency Contact Name"
											value="${bean.otherInfo.emergencyCP}" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<label>Nationality</label> <select
											name="otherInfo.nationality" class="form-control">
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
										<label>Father Name</label> <input readonly readonly
											name="otherInfo.fatherNM" class="form-control" type="text"
											placeholder="Please Enter Father Name"
											value="${bean.otherInfo.fatherNM}" />
									</div>
								</div>

							</div>
							<div class="col-md-4">
								<div class="row">
									<div class="col-md-12 form-group">
										<label>Mother Name</label> <input readonly readonly
											name="otherInfo.motherNM" class="form-control" type="text"
											placeholder="Please Enter Mother Name"
											value="${bean.otherInfo.motherNM}" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<label>Spouse Name</label> <input readonly readonly
											name="otherInfo.spouseNM" class="form-control" type="text"
											placeholder="Please Enter Spouse Name"
											value="${bean.otherInfo.spouseNM}" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<label>Passport Number</label> <input
											name="otherInfo.passport" class="form-control" type="text"
											placeholder="Please Enter Passport Number"
											value="${bean.otherInfo.passport}" />

									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<label>Aadhar Number</label> <input readonly readonly
											name="otherInfo.adhar" class="form-control" type="text"
											placeholder="Please Enter Aadhar Number"
											value="${bean.otherInfo.adhar}" />

									</div>
								</div>
								<br>


							</div>
						</div>

					</div>
				</div>
			</div>
			<br> <br>
			<%
				List<EmployeeAddressInfoBean> addressInfoBeans = bean.getAddressInfoBeans();
				int i = 0;
				for (EmployeeAddressInfoBean addressBean : addressInfoBeans) {
			%>
			<div class="row">
				<div class="col-md-8 offset-2 card form1">
					<div class="card-body">
						<h4 class="text-center border-bottom">EMPLOYEE ADDRESS
							INFORMATION</h4>
						<br>
						<div class="row">
							<div class="col-md-6">
								<div class="row">
									<div class="col-md-12 form-group">
										<label>Address Type</label> <select class="form-control"
											name="addressInfoBeans[<%=i%>].addressPKBean.addressType"
											required>
											<option value="" disabled>-- select one --</option>
											<%
												if (addressBean.getAddressPKBean().getAddressType().equalsIgnoreCase("temporary")) {
											%>
											<option selected>Temporary</option>
											<option>Permanent</option>
											<%
												} else {
											%>
											<option>Temporary</option>
											<option selected>Permanent</option>
											<%
												}
											%>
										</select>
									</div>
								</div>

								<div class="row">
									<div class="col-md-12 form-group">
										<label>Address1</label> <input readonly readonly
											class="form-control" type="text"
											name="addressInfoBeans[<%=i%>].address1"
											value="<%=addressBean.getAddress1()%>"
											placeholder="Enter Address Line 1" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<label>Address2</label> <input readonly class="form-control"
											type="text" name="addressInfoBeans[<%=i%>].address2"
											value="<%=addressBean.getAddress2()%>"
											placeholder="Enter Address Line 2" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<label>Landmark</label> <input readonly class="form-control"
											type="text" name="addressInfoBeans[<%=i%>].landmark"
											value="<%=addressBean.getLandmark()%>"
											placeholder="Enter Address Landmark" />
									</div>
								</div>

							</div>
							<div class="col-md-6">
								<div class="row">
									<div class="col-md-12 form-group">
										<label>City</label> <input readonly class="form-control"
											type="text" name="addressInfoBeans[<%=i%>].city"
											value="<%=addressBean.getCity()%>"
											placeholder="Please Enter City" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<label>State</label> <input readonly class="form-control"
											type="text" name="addressInfoBeans[<%=i%>].state"
											value="<%=addressBean.getState()%>"
											placeholder="Please Enter State" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<label>Country</label> <input readonly class="form-control"
											type="text" name="addressInfoBeans[<%=i%>].country"
											value="<%=addressBean.getCountry()%>"
											placeholder="Please Enter Country" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12 form-group">
										<label>Pincode</label> <input readonly class="form-control"
											type="number" name="addressInfoBeans[<%=i%>].pin"
											value="<%=addressBean.getPin()%>"
											placeholder="Please Enter Pincode" />
									</div>
								</div>

								<br>

							</div>
						</div>
					</div>
				</div>
			</div>
			<br> <br>
			<%
				i++;
				}
				List<EmployeeEducationInfoBean> educationInfoBeans = bean.getEducationInfoBeans();
				i = 0;
				for (EmployeeEducationInfoBean educationBean : educationInfoBeans) {
			%>

			<div class="row">
				<div class="col-md-8 offset-2 card form1">
					<div class="card-body">
						<h4 class="text-center border-bottom">Educational Details</h4>
						<br>
						<div class="col-auto">
							<label class="sr-only" for="education_type">Education
								Type</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">Education Type</div>
								</div>
								<input readonly type="text" class="form-control" required
									name="educationInfoBeans[<%=i%>].educationPKBean.educationalType"
									value="<%=educationBean.getEducationPKBean().getEducationalType()%>"
									placeholder="Enter Education Type"> <span id="id-error"
									class="text-danger small"></span>
							</div>
						</div>
						<div class="col-auto">
							<label class="sr-only" for="degree_type">Degree Type</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">Degree Type</div>
								</div>
								<input readonly type="text" class="form-control"
									id="degree_type" name="educationInfoBeans[<%=i%>].degreeType"
									value="<%=educationBean.getDegreeType()%>"
									placeholder="Enter Degree Type"> <span id="id-error"
									class="text-danger small"></span>
							</div>
						</div>
						<div class="col-auto">
							<label class="sr-only" for="branch">Branch</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">Branch</div>
								</div>
								<input readonly type="text" class="form-control" id="branch"
									placeholder="Enter Degree Branch"> <span id="id-error"
									class="text-danger small"></span>
							</div>
						</div>

						<div class="col-auto">
							<label class="sr-only" for="college_name">College Name</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">College Name</div>
								</div>
								<input readonly type="text" class="form-control"
									id="college_name" name="educationInfoBeans[<%=i%>].collegeNM"
									value="<%=educationBean.getCollegeNM()%>"
									placeholder="Enter College Name"> <span id="id-error"
									class="text-danger small"></span>
							</div>
						</div>
						<div class="col-auto">
							<label class="sr-only" for="university">University</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">University</div>
								</div>
								<input readonly type="text" class="form-control" id="university"
									name="educationInfoBeans[<%=i%>].university"
									value="<%=educationBean.getUniversity()%>"
									placeholder="Enter University Name"> <span
									id="id-error" class="text-danger small"></span>
							</div>
						</div>
						<div class="col-auto">
							<label class="sr-only" for="yop">Year Of Passing</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">Year Of Passing</div>
								</div>
								<input readonly type="text" class="form-control" id="yop"
									value="<%=educationBean.getYop()%>"
									name="educationInfoBeans[<%=i%>].yop" placeholder="dd-mm-yyyy">
								<span id="id-error" class="text-danger small"></span>
							</div>
						</div>
						<div class="col-auto">
							<label class="sr-only" for="percentage">Percentage</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">Percentage</div>
								</div>
								<input readonly type="text" class="form-control" id="percentage"
									name="educationInfoBeans[<%=i%>].percentage"
									value="<%=educationBean.getPercentage()%>"
									placeholder="Enter Percentage"> <span id="id-error"
									class="text-danger small"></span>
							</div>
						</div>
						<div class="col-auto">
							<label class="sr-only" for="location">Location</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">Location</div>
								</div>
								<input readonly type="text" class="form-control" id="location"
									name="educationInfoBeans[<%=i%>].location"
									value="<%=educationBean.getLocation()%>"
									placeholder="Enter College Location"> <span
									id="id-error" class="text-danger small"></span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<br> <br>
			<%
				i++;
				}
				List<EmployeeExperienceInfoBean> experienceInfoBeans = bean.getExperienceInfoBeans();
				i = 0;
				for (EmployeeExperienceInfoBean experienceInfoBean : experienceInfoBeans) {
			%>
			<div class="row">
				<div class="col-md-8 offset-2 card form1">
					<div class="card-body">
						<h4 class="text-center border-bottom">Employee Experience
							Details</h4>
						<br>

						<div class="col-auto">
							<label class="sr-only" for="company_name">Company Name</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">Company Name</div>
								</div>
								<input readonly type="text" required class="form-control"
									name="experienceInfoBeans[<%=i%>].experiencePKBean.companyName"
									value="<%=experienceInfoBean.getExperiencePKBean().getCompanyName()%>"
									
									id="company_name" placeholder="Enter Company Name">
							</div>
						</div>
						<div class="col-auto">
							<label class="sr-only" for="designation">Designation</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">Designation</div>
								</div>
								<input readonly type="text" class="form-control"
									id="designation" name="experienceInfoBeans[<%=i%>].designation"
									value="<%=experienceInfoBean.getDesignation()%>"
									placeholder="Enter Designation">
							</div>
						</div>
						<div class="col-auto">
							<label class="sr-only" for="joining_date">Joining Date</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">Joining Date</div>
								</div>
								<input readonly type="date" class="form-control"
									id="joining_date" name="experienceInfoBeans[<%=i%>].joiningDate"
									value="<%=formatter.format(experienceInfoBean.getJoiningDate())%>"
									placeholder="dd-mm-yyyy">
							</div>
						</div>

						<div class="col-auto">
							<label class="sr-only" for="leaving_date">Leaving Date</label>
							<div class="input-group mb-2">
								<div class="input-group-prepend">
									<div class="input-group-text">Leaving Date</div>
								</div>
								<input readonly type="date" class="form-control"
									id="leaving_date" name="experienceInfoBeans[<%=i%>].releavingDate"
									value="<%=formatter.format(experienceInfoBean.getReleavingDate())%>"
									placeholder="dd-mm-yyyy">
							</div>
						</div>

					</div>
				</div>
			</div>
			<br> <br>
			<%
				i++;
				}
			%>
			

			<div class=" row text-center">
				<button type="button"
					class="offset-md-2 col-md-4 btn btn-outline-dark"
					style="border-radius: 3px 0 0 3px; border-right: 0;">Reset</button>
				<button type="submit" class="col-md-4 btn btn-outline-info"
					style="border-radius: 0 3px 3px 0;">Submit</button>

			</div>
			<br> <br>
		</form>

	</div>
</body>
</html>