<%@page import="com.mishra.entity.InterestModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% InterestModel interestModel= (InterestModel)request.getAttribute("InterestEntity"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr>
	<h4>Complete Details</h4>
	<hr>
	<pre>
	Name 	= <%=interestModel.getName() %>
	Income 	= <%= interestModel.getIncome() %>
	Rebate 	= <%=interestModel.getRebate() %>
	Total-Tax =<%=interestModel.getTotalTax() %>
	Net Income = <%=interestModel.getNetIncome() %>
	
</pre>
	<hr>
</body>
</html>