<%@page import="com.te.springmvc.beans.EmployeeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<%
String msg = (String) request.getAttribute("msg");
String errmsg = (String) request.getAttribute("errmsg");
List<EmployeeBean> emp = (List<EmployeeBean>) request.getAttribute("empData");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
	if (msg != null && !msg.isEmpty()) {
	%>
	<h1 style="color: red">
		<%=msg%>
	</h1>
	<%
	}
	%>
	<%
	if (errmsg != null && !errmsg.isEmpty()) {
	%>
	<h1 style="color: red">
		<%=errmsg%>
	</h1>
	<%
	}
	%>

	<br>
	<br>

	<table border="1" style="width: 80%">
		<tr style='background-color: lightgrey; color: blue; height: 30px'>
			<th style="font-size: 20px">Employee Id</th>
			<th style="font-size: 20px">First Name</th>
			<th style="font-size: 20px">Last Name</th>
			<th style="font-size: 20px">Email</th>
			<th style="font-size: 20px">Dob</th>

		</tr>

		<%
		for (EmployeeBean employeeBean : emp) {
		%>
		<tr style='background-color: lightgrey; color: blue; height: 30px'>
			<td style="font-size: 20px"><%=employeeBean.getEmpid()%></td>
			<td style="font-size: 20px"><%=employeeBean.getFirstName()%></td>
			<td style="font-size: 20px"><%=employeeBean.getLastName()%></td>
			<td style="font-size: 20px"><%=employeeBean.getEmail()%></td>
			<td style="font-size: 20px"><%=employeeBean.getDob()%></td>
		</tr>
		<%
		}
		%>



	</table>





</body>
</html>