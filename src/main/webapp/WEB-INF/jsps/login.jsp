<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Please login</title>
</head>
<body>
	<form:form commandName="user">
		<table>
			<tr>
				<td>Username:</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Login"></td>
			</tr>
			<tr>
				<td colspan="2"><a href="register.page">register</a></td>
			</tr>
			<tr>
				<td colspan="2">
					<p>
						Note: Your username will be your email-id.
					</p>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>