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
						<form:errors path="firstName" cssClass="error"/>
					</div>
					<div>
						<form:label path="lastName">First Name</form:label>
						<form:input path="lastName" spellcheck="false"
							placeholder="LastName" />
						<form:errors path="lastName" cssClass="error"/>
					</div>
					<div>
						<form:label path="email">Email</form:label>
						<form:input path="email" spellcheck="false"
							placeholder="xyz@xyz.com" />
						<form:errors path="email" cssClass="error"/>
					</div>
					<div>
						<form:label path="password">Password</form:label>
						<form:password path="password" />
						<form:errors path="password" cssClass="error"/>
					</div>
					<div>
						<form:label path="confirm">Confirm Password</form:label>
						<form:password path="confirm" />
						<form:errors path="confirm" cssClass="error"/>
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