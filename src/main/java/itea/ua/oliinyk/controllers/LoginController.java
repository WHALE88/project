package itea.ua.oliinyk.controllers;

import itea.ua.oliinyk.dao.UserDAO;
import itea.ua.oliinyk.entity.User;
import itea.ua.oliinyk.md5.MD5;
import itea.ua.oliinyk.validation.LogValidator;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.persistence.NoResultException;
import javax.validation.Valid;
import java.util.Locale;

//import org.apache.commons.lang3.StringUtils;

@Controller
@SessionAttributes("user")
public class LoginController {

  private static final int WEAK = 10;
  private static final int STRONG = 15;

  @Resource
  private MessageSource messageSource;

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String doGetPage(ModelMap model, Locale locale) {
    locale.getDisplayLanguage();
    messageSource.getMessage("locale", new String[]{locale.getDisplayName(locale)}, locale);

    LogValidator validator = (LogValidator) model.get("validator");
    if (validator == null) {
      validator = new LogValidator();
      model.addAttribute("validator", validator);
    }
    return "login";
  }

  @GetMapping(path = "/checkStrength", produces = MediaType.TEXT_PLAIN_VALUE)
  public @ResponseBody
  String checkStrength(@RequestParam("password") String password) {
    if (password.length() < WEAK) {
      return "WEAK";
    } else if (password.length() < STRONG) {
      return "MIDDLE";
    }
    return "STRONG";
  }

  @PostMapping(path="/login")
  public ModelAndView checkUser(Locale locale, @Valid @ModelAttribute("validator") LogValidator validator, BindingResult bindingResult,
                                ModelMap model) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("locale", messageSource.getMessage("locale", new String[]{locale.getDisplayName(locale)}, locale));

    String url;
    if (bindingResult.hasErrors()) {
      url = "login";
      modelAndView.setViewName(url);
    }
    UserDAO userdao = new UserDAO();
    String password = new MD5().md5Custom(validator.getPassword());
    User user = null;
    try {
      user = userdao.getUser(validator.getLogin(), password);
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
