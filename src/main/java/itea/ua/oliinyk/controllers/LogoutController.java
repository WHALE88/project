package itea.ua.oliinyk.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping(value = "/logout")
public class LogoutController {

  @GetMapping
  public String getLogoutPage(ModelMap model) {
    return "logout";
  }

  @PostMapping
  public String logout(SessionStatus sess, HttpSession session) {
    // sess.setComplete();
    session.removeAttribute("user");
    session.removeAttribute("cart");
    return "homepage";
  }
}
