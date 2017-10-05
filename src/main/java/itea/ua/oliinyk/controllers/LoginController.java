package itea.ua.oliinyk.controllers;

import java.util.Locale;

import javax.persistence.NoResultException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
//import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import itea.ua.oliinyk.dao.UserDAO;
import itea.ua.oliinyk.entity.User;
import itea.ua.oliinyk.md5.MD5;
import itea.ua.oliinyk.validation.LogValidator;

@Controller
@SessionAttributes("user")
public class LoginController {

	private static final int WEAK = 10;
	private static final int STRONG = 15;
	
	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String doGetPage(ModelMap model, Locale locale) {
		locale.getDisplayLanguage();
		messageSource.getMessage("locale", new String[] {locale.getDisplayName(locale)}, locale);
		String url;
		LogValidator validator = (LogValidator) model.get("validator");
		if (validator == null) {
			validator = new LogValidator();
			model.addAttribute("validator", validator);
		} else {
			validator = (LogValidator) model.get("validator");
		}
		url = "login";
		return url;
	}

	@RequestMapping(value = "/checkStrength", method = RequestMethod.GET, produces = { "text/plain; charset=UTF-8" })
	public @ResponseBody String checkStrength(@RequestParam("password") String password) {
		if (password.length() < WEAK) {
			return "WEAK";
		} else if (password.length() >= WEAK & password.length() < STRONG) {
			return "MIDDLE";
		} else if (password.length() >= STRONG) {
			return "STRONG";
		}
		return "";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView checkUser(Locale locale, @Valid @ModelAttribute("validator") LogValidator validator, BindingResult bindingResult,
			ModelMap model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("locale", messageSource.getMessage("locale", new String[] {locale.getDisplayName(locale)}, locale));
		
		String url = "login";
		if (bindingResult.hasErrors()) {
			url = "login";
			modelAndView.setViewName(url);
		}
		UserDAO userdao = new UserDAO();
		String password = new MD5().md5Custom(validator.getPassword());
		User user = null;
		try {
			user = (User) userdao.getUser(validator.getLogin(), password);
		} catch (NoResultException ex) {
			ex.printStackTrace();
		}
	
		if (user != null) {
			model.addAttribute("user", user);
			url = "logout";
			modelAndView.setViewName(url);
		}
		return modelAndView;
	}
}
