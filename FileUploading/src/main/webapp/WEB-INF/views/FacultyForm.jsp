
<%@taglib uri="http://www.springframework.org/tags/form"
	prefix="springTag"%>
<%@page isELIgnored="false"%>
<html>
<head>
<meta charset="UTF-8">
<title>Faculty-Details</title>
</head>
<body bgcolor="fefcb7">
	<h4>Faculty Details</h4>
	<hr>
	<hr>
	<!-- below we are using sprin form and using Modeltrribute and acessing model or binding model
here faculty is our model atribute name which we saved in our modelandView object in controller  -->
	<springTag:form action="SaveFaculty"  modelAttribute="faculty" method="post" enctype="multipart/form-data">
		<table align="center">
			<tr>
				<td>Roll No</td>
					<td>
						<springTag:input path="rno" />  <springTag:errors path="rno"></springTag:errors> 
					</td>
			</tr>
			<tr>
				<td>Name</td>
				<td>
					<springTag:input path="name"/> <%-- <springTag:errors path="name"></springTag:errors> --%>
				</td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td>
					<springTag:input path="mobile"/> <springTag:errors path="mobile"></springTag:errors> 
				</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>
					<springTag:input path="email"/> <springTag:errors path="email"></springTag:errors> 
				</td>
			</tr>
			<tr>
				<td>Address</td>
				<td>
					<springTag:input path="address"/> <springTag:errors path="address"></springTag:errors> 
				</td>
			</tr>
			<tr>
				<td>Picture</td>
				<td>
				<input type="file" name="image">
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

	<!--the below line or error tag is used to print error 
	use use attribute value of model whih we are checking
	here * is used to print all error in a single place  -->
	 <springTag:errors path="faculty.*"></springTag:errors>  
</body>
</html>