<%@page import="com.fit.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	User u = new User();
	u = (User) request.getAttribute("user");
	%>
	Fist Name:
	<%
	out.println(u.getFname());
	%><br> Last Name:
	<%
	out.println(u.getLname());
	%><br> Email:
	<%
	out.println(u.getEmail());
	%><br> Birthday:
	<%
	out.println(u.getDob());
	%><br> Gender:
	<%
	out.println(u.getGender());
	%><br>
</body>
</html>