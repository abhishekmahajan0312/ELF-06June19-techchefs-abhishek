<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
	int userId = Integer.parseInt(request.getAttribute("userId").toString());
	String password = request.getAttribute("password").toString();
%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	User Id =
	<%=userId%><br> Password =
	<%=password%>
</body>
</html>