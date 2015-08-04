package in.indigenous.myapp.controllers;

import in.indigenous.myapp.model.User;
import in.indigenous.myapp.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String showLoginPage(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Model model, @ModelAttribute User user) {
		boolean success = userService.login(user);
		if (success) {
			// TODO - Add success message.
			return "redirect:home.page";
		} else {
			// TODO - Add failure message.
			return "login";
		}
	}

	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String showRegisterPage(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(Model model, @ModelAttribute User user) {
		if (!user.getConfirm().equals(user.getPassword())) {
			// TODO - Add password confirm message.
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
