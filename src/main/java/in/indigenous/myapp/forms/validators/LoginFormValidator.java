package in.indigenous.myapp.forms.validators;

import in.indigenous.myapp.forms.beans.LoginFormBean;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LoginFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return LoginFormBean.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"email.required", "email is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"password.required", "password is required");
	}

}
