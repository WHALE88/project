package itea.ua.oliinyk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class ItsMyController {

	@RequestMapping(method=RequestMethod.GET)
	public String printMyMessage(ModelMap model) {
		model.addAttribute("mymessage", "Test");
		return "mypage";
	}
}
