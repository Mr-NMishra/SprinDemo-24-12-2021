<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form"
	prefix="springTag"%>
<%@page isELIgnored="false" %>
<html>
<head>
<meta charset="UTF-8">
<title>Faculty-Details</title>
</head>
<body bgcolor="fefcb7">
	<h4>Faculty Details</h4>
	<hr>
	<hr>

	<springTag:form action="Studentform" method="get" modelAttribute="faculty">
		<table align="center">
			<tr>
				<td>Roll No</td>
				<td><input type="text" name="rno"></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td><input type="text" name="mobile"></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td>Degree</td>
				<td>
					<springTag:select path="degree" items="${degreeList}">
						
					</springTag:select>
				</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>
					<springTag:radiobuttons items="${gender}" path="gender" />
				</td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><input type="reset"><input
					type="submit" name="submit"></td>
			</tr>
		</table>
	</springTag:form>
	<hr>
	<hr>
</body>
</html>