<%@page import="com.mishra.model.InterestModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- Here we process the data send by controller -->
<%
InterestModel model= (InterestModel)session.getAttribute("model");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>Interset details</h3>
	<hr>
	<pre>
	Amount 		<%=model.getAmount() %>
	Time 		<%=model.getTime() %>
	Rate 		<%= model.getRate() %>
	Interest 	<%=model.getInterest() %>
	NetAmount 	<%=model.getNetAmount() %>
	</pre>
	<hr>
</body>
</html>