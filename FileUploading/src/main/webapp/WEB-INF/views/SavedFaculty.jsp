<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="test"%>
<%@page import="com.mishra.entity.Student"%>
<%@page import="com.mishra.entity.Faculty"%>
<%@page isELIgnored="false" %>
<html>
<head>

<title>Insert title here</title>
</head>
<body>
	<h3>Saved Faculty Details</h3>
	<hr>
	<table border="1">
		<tr>
			<th>Roll No.</th>
			<th>Name</th>
			<th>Mobile</th>
			<th>Address</th>
			<th>Picture</th>
		</tr>

		<%-- <test:forEach items="${students}" var="student"> --%>
		<tr>
			<td>${faculty.rno}</td>
			<td>${faculty.name}</td>
			<td>${faculty.mobile}</td>
			<td>${faculty.address}</td>
			<td><img height="50" src="image?id=${faculty.rno }"> </td>
			
		</tr>
	<%-- 	</test:forEach> --%>

	</table>
	<hr>
<a href="index.jsp">Go to Home</a>
</body>
</html>