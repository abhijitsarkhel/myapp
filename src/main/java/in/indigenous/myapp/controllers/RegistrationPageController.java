package in.indigenous.myapp.controllers;

import in.indigenous.myapp.forms.beans.RegistrationFormBean;
import in.indigenous.myapp.services.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationPageController {

	@Autowired
	private UserService userService;

	@Autowired
	private Validator registrationFormValidator;

	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationPageController.class);

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(registrationFormValidator);
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String showRegisterPage(Model model) {
		LOGGER.info("Inside showRegisterPage method");
		model.addAttribute("user", new RegistrationFormBean());
		return "register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(Model model,
			@ModelAttribute("user") @Validated RegistrationFormBean user,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		LOGGER.info("Inside register method");
		// registrationFormValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("user", user);
			return "register";
		}
		boolean success = userService.register(user);
		if (success) {
			LOGGER.debug("Registration successful for user " + user.getEmail());
			redirectAttributes.addFlashAttribute("message", "Registration successful");
		} else {
			LOGGER.warn("Registration failed for user " + user.getEmail());
			redirectAttributes.addFlashAttribute("message", "Registration Failed");
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
