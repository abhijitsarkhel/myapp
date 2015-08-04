<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Please login</title>
<link rel="stylesheet" href="static/css/login-style.css">
</head>
<body>
	<div class="login">
		<div class="heading">
			<h2>Sign in</h2>
			<form:form commandName="user">
				<div class="input-group input-group-lg">
					<span class="input-group-addon"><i class="fa fa-user"></i></span>
					<form:input path="email" class="form-control" placeholder="email" />
				</div>

				<div class="input-group input-group-lg">
					<span class="input-group-addon"><i class="fa fa-lock"></i></span>
					<form:password path="password" class="form-control"
						placeholder="Password" />
				</div>
				<button type="submit" class="float">Login</button>
				<div class="input-group input-group-lg">
					<a href="register.page">New user? register here</a>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>