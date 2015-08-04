<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Register</title>
<link rel="stylesheet" href="static/css/register-style.css">
<script type="text/javascript">
	$(document).ready(function() {
		var placeholder = null;
		$('input[type=text]').focus(function() {
			placeholder = $(this).attr("placeholder");
			$(this).attr("placeholder", "");
		});
		$('input[type=text]').blur(function() {
			$(this).attr("placeholder", placeholder);
		});
	});
</script>
</head>
<body>
	<div class="main">
		<div class="two">
			<div class="register">
				<h3>Create your account</h3>
				<form:form commandName="user">
					<div>
						<form:label path="firstName">First Name</form:label>
						<form:input path="firstName" spellcheck="false"
							placeholder="FirstName" />
					</div>
					<div>
						<form:label path="lastName">First Name</form:label>
						<form:input path="lastName" spellcheck="false"
							placeholder="LastName" />
					</div>
					<div>
						<form:label path="email">Email</form:label>
						<form:input path="email" spellcheck="false"
							placeholder="xyz@xyz.com" />
					</div>
					<div>
						<form:label path="password">Password</form:label>
						<form:password path="password" />
					</div>
					<div>
						<form:label path="confirm">Confirm Password</form:label>
						<form:password path="confirm" />
					</div>
					<div>
						<label></label> <input type="submit" value="Register"
							class="button" />
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>