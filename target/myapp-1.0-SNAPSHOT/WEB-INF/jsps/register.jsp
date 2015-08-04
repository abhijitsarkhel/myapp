<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Register</title>
</head>
<body>
	<form:form commandName="user">
		<table>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td> Email: </td>
				<td> <form:input path="email" /></td>
			</tr>
			<tr>
				<td> Password: </td>
				<td> <form:password path="password" /></td>
			</tr>
			<tr>
				<td> Confirm Password: </td>
				<td> <form:password path="confirm" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>