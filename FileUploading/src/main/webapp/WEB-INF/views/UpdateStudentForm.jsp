<%@taglib uri="http://www.springframework.org/tags/form"
	prefix="springTag"%>
<%@page isELIgnored="false"%>
<html>
<head>
<meta charset="UTF-8">
<title>update-Student</title>
</head>
<body bgcolor="fefcb7">
	<h4>Student Details</h4>
	<hr>
	<hr>
	<springTag:form action="UpdatingStudent" modelAttribute="updateStudent">

		<!-- <form action="UpdatingStudent" method="get"> -->
		<table align="center">
			
			<tr>
				<td>Roll No</td>
				<springTag:input path="rno"/>
			</tr>
			<tr>
				<td>Name</td>
				<springTag:input path="name"/>
			</tr>
			<tr>
				<td>Mobile</td>
				<springTag:input path="mobile"/>
			</tr>
			<tr>
				<td>Address</td>
				<springTag:input path="address"/>
			</tr>
			<tr>
				<td></td>
				<td align="right"><input type="reset"><input
					type="submit" value="update"></td>
			</tr>
			</pre>
		</table>
		<a href="back"><input type="button" value="back"></a>
		<!-- 	</form> -->
	</springTag:form>
	<hr>
	<hr>
</body>
</html>