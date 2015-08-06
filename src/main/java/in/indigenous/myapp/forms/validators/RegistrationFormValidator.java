package in.indigenous.myapp.forms.validators;

import in.indigenous.myapp.forms.beans.RegistrationFormBean;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class RegistrationFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return RegistrationFormBean.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
				"firstName.required", "First name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName",
				"lastName.required", "Last name is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"email.required", "email is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"password.required", "password is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirm",
				"confirm.required", "password must be confirmed");
		RegistrationFormBean user = (RegistrationFormBean) obj;
		if (!user
				.getEmail()
				.matches(
						"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
			errors.rejectValue("email", "invalidEmail",
					new Object[] { "'email'" }, "email is invalid");
		}
		if (!user.getPassword().equals(user.getConfirm())) {
			errors.rejectValue("confirm", "passwordsNotMatch",
					new Object[] { "'confirm'" },
					"password and confirm password should match");
		}
	}

}
