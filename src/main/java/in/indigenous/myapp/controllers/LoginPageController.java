package in.indigenous.myapp.controllers;

import in.indigenous.myapp.forms.beans.LoginFormBean;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginPageController {

	@Autowired
	private UserService userService;

	@Autowired
	private Validator loginFormValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(loginFormValidator);
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String showLoginPage(Model model) {
		model.addAttribute("user", new LoginFormBean());
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Model model,
			@ModelAttribute("user") @Validated LoginFormBean user,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		// loginFormValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute("user", user);
			return "login";
		}
		boolean success = userService.login(user);
		if (success) {
			redirectAttributes.addFlashAttribute("message", "You are successfully logged in.");
			return "redirect:home.page";
		} else {
			model.addAttribute("message", "Login failed");
			return "login";
		}
	}
}
