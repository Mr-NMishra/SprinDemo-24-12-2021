<%@page import="com.mishra.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Student student = (Student) request.getAttribute("student");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>
</head>
<body>
	<h3>Student Details</h3>
	<hr>
	<hr>
	<pre>
	Roll No : <%=student.getRno() %>
	Name : <%=student.getName()%>
	Mobile : <%=student.getMobile()%>
	Address : <%=student.getAddress()%>
</pre>
	<hr>
	<hr>
	<a href="index.jsp">Home</a><br>
	<a href="ViewForm">Add new Student</a>
</body>
</html>