package itea.ua.oliinyk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainPageController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getPage() {
		return "homepage";
	}

	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public String doGetPage() {
		String url;
		url = "homepage";
		return url;
	}

}
