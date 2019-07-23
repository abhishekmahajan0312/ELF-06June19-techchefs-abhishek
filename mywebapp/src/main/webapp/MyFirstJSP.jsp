<!DOCTYPE html>
<%@page import="java.util.Date"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My First HTML</title>
</head>
<body>
	<h1>
	Current Date and Time is : 
	<% 
	String currentDateTime = new Date().toString();
	%>
	<br>
	<span style="color: red;"><%=currentDateTime%></span><br>
	</h1>
</body>
</html>