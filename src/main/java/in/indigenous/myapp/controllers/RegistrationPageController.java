package in.indigenous.myapp.controllers;

import in.indigenous.myapp.forms.beans.RegistrationFormBean;
import in.indigenous.myapp.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationPageController {

	@Autowired
	private UserService userService;

	@Autowired
	private Validator registrationFormValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(registrationFormValidator);
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String showRegisterPage(Model model) {
		model.addAttribute("user", new RegistrationFormBean());
		return "register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(Model model,
			@ModelAttribute("user") @Validated RegistrationFormBean user,
			BindingResult bindingResult) {
		//registrationFormValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("user", user);
			return "register";
		}
		boolean success = userService.register(user);
		if (success) {
			// TODO - Add success message.
		} else {
			// TODO - Add failure message.
		}
		return "redirect:login.page";
	}

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String showHomePage() {
		return "home";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
