<%@page import="com.te.springmvc.beans.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String msg = (String) request.getAttribute("errmsg");
EmployeeBean bean = (EmployeeBean) request.getAttribute("data");
%>
<%@ include file="header.jsp"%>
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

	<fieldset>
		<legend>Search Form</legend>

		<form action="./search1" method="get">
			<table>

				<tr>
					<td><input type="text" name="id" placeholder="Employee ID">
					</td>
				</tr>

				<tr>
					<td><input type="submit" value="Search"></td>
				</tr>

			</table>



		</form>
	</fieldset>

	<%
	if (bean != null) {
	%>
	<h4>
		First Name:
		<%=bean.getFirstName()%></h4>

	<h4>
		Last Name:
		<%=bean.getLastName()%></h4>
	<%
	}
	%>
</body>
</html>