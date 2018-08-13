package ua.com.oliinyk.controllers;

import javax.persistence.NoResultException;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.com.oliinyk.dao.UserDAO;
import ua.com.oliinyk.entity.User;
import ua.com.oliinyk.md5.MD5;
import ua.com.oliinyk.validation.RegValidator;

@Controller
@SessionAttributes("user")
public class RegistrationController {

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String doGetPage(ModelMap model) {
		String url;
		RegValidator validator = (RegValidator) model.get("validator");
		if (validator == null) {
			validator = new RegValidator();
			model.addAttribute("validator", validator);
		} else {
			validator = (RegValidator) model.get("validator");
		}
		url = "registration";
		return url;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String checkUser(@Valid @ModelAttribute("validator") RegValidator validator, BindingResult bindingResult,
			ModelMap model) {
		String url = "registration";
		if (!validator.getPassword().equals(validator.getRetypePassword())) {
			ObjectError error = new ObjectError("retypePassword", "Passwords don't match");
			bindingResult.addError(error);
		}
		if (bindingResult.hasErrors()) {
			url = "registration";
			return url;
		}
		String password = new MD5().md5Custom(validator.getPassword());
		UserDAO userdao = new UserDAO();
		User user = null;
		try {
			userdao.isUserExist(validator.getLogin(), validator.getEmail());	
		} catch (NoResultException ex) {
			user = new User();
			user.setLogin(validator.getLogin());
			user.setEmail(validator.getEmail());
			user.setPassword(password);
			user.setName(validator.getName());
			user.setPhonenumber(validator.getPhonenumber());
			user.setGender(validator.getGender());
			user.setRegion(validator.getRegion());
			user.setFeedback(validator.getFeedback());
			user = userdao.add(user);
		}

		if (user != null) {
			model.addAttribute("user", user);
			url = "logout";
			return url;
		} else {
			ObjectError error1 = new ObjectError("userExist", "User with this login or email exist");
			bindingResult.addError(error1);
		}

		return url;
	}
}