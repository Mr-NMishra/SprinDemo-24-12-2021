<%@page isELIgnored="false" %>
<html>
<head>
<meta charset="UTF-8">
<title>update-Student</title>
</head>
<body bgcolor="fefcb7">
	<h4>Student Details</h4>
	<hr>
	<hr>

	<form action="Studentform" method="get">
		<table align="center">
			<tr>
				<td>Roll No</td>
				<td><input type="text" name="rno" value=${updateStudent.rno }></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" value=${updateStudent.name }></td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td><input type="text" name="mobile" value=${updateStudent.mobile }></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" value=${updateStudent.address }></td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><input type="reset"><input type="submit"  value="update"></td>
			</tr>
		</table>
		<a href="back" ><input type="button" value="back"></a>
	</form>
	<hr>
	<hr>
</body>
</html>