<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String msg = (String) request.getAttribute("errmsg");
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

	<fieldset>
		<legend>Login Form</legend>

		<form action="./empLogin" method="post">
			<table>

				<tr>
					<td><input type="text" name="id" placeholder="Username">
					</td>
				</tr>


				<tr>
					<td><input type="password" name="password"
						placeholder="Password"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login"></td>
				</tr>

			</table>



		</form>
	</fieldset>

</body>
</html>