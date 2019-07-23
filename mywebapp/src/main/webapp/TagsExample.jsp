
<%!public String name = "Rajani Kanth";
	private int age = 100;

	{
		System.out.println("Inside My Block");
		
	}
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getName(String name) {
		return "Given Name is :-" + name;
	}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> JSP Tags Example</h1>
	Name 1: <%=name %><br>
	Name 2: <%=getName() %><br>
	Name 3: <%=getName("Abhishek") %><br>
	Age 1: <%=age %><br>
	Age 2: <%=getAge() %><br>
	
	<%
		for(int i=0;i<5;i++){
			%>
			Name 1: <%=name%><br>
			
			<%
			
			
		}
	%>
	
</body>
</html>