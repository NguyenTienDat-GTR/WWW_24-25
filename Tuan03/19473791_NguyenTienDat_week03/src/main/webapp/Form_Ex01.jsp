<%@page import="com.fit.entity.Person"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	First Name:
	<%
Person p = new Person();
	p = (Person)request.getAttribute("person");
String fname = p.getFname();
out.println(fname);
%><br>
	Last Name:
	<%
String lname = p.getLname();
out.println(lname);
%><br>
	Date of birth:
	<%
String day = p.getBirthDate();
	out.println(day);
%><br>
Email:
<%
String email = p.getEmail();
	out.println(email);
%><br>
Mobile number:
<%
String phone = p.getPhone();
	out.println(phone);
%><br>
Gender:
<%
String gender = p.getGender();
	out.println(gender);
%><br>
Address:
<%
String address = p.getAddress();
	out.println(address);
%><br>
City:
<%
String city = p.getCity();
	out.println(city);
%><br>
Pin code:
<%
String pin = p.getPinCode();
	out.println(pin);
%><br>
State:
<%
String state = p.getState();
	out.println(state);
%><br>
Country:
<%
String country = p.getCountry();
	out.println(country);
%><br>
Hobbies: 
<%
for(String hobbi : p.getHobbies())
	out.println(hobbi +",");
%><br>
Course:
<%
String course =p.getCourse();
	out.println(course);
%><br>

</body>
</html>