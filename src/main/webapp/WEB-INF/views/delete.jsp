<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%
String msg = (String) request.getAttribute("msg");
String errmsg = (String) request.getAttribute("errmsg");
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
	<fieldset>
		<legend>Delete Form</legend>

		<form action="./delete" method="get">
			<table>

				<tr>
					<td><input type="text" name="id" placeholder="Employee ID">
					</td>
				</tr>

				<tr>
					<td><input type="submit" value="Delete"></td>
				</tr>

			</table>

		</form>
	</fieldset>

</body>
</html>