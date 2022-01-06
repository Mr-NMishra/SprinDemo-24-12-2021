<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="test"%>
<%@page import="com.mishra.entity.Student"%>
<%@page isELIgnored="false" %>
<html>
<head>

<title>Insert title here</title>
</head>
<body>
	<h3>Saved Student Details</h3>
	<hr>
	<table border="1">
		<tr>
			<th>Roll No.</th>
			<th>Name</th>
			<th>Mobile</th>
			<th>Address</th>
			<th>Delete</th>
			<th>Edit</th>
		</tr>

		<test:forEach items="${students}" var="student">
		<tr>
			<td>${student.rno}</td>
			<td>${student.name}</td>
			<td>${student.mobile}</td>
			<td>${student.address}</td>
			<td align="center"><a href="delete?id=${student.rno}">[X]</a></td>
			<td align="center"><a href="update?id=${student.rno}" >Update</a></td>
		</tr>
		</test:forEach>

	</table>
	<hr>
<a href="index.jsp">Go to Home</a>
</body>
</html>