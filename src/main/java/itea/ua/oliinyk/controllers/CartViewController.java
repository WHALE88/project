package itea.ua.oliinyk.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.velocity.VelocityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import itea.ua.oliinyk.dao.OrderDAO;
import itea.ua.oliinyk.entity.Cart;
import itea.ua.oliinyk.entity.User;
import itea.ua.oliinyk.orders.Order;
import itea.ua.oliinyk.service.EmailService;

@Controller
public class CartViewController {
	@Autowired
	EmailService emailService;

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String view(ModelMap model) {
		Cart cart = (Cart) model.get("cart");
		model.addAttribute("cart", cart);
		String url = "cart";
		return url;
	}

	@RequestMapping(value = "/confirm", method = RequestMethod.GET)
	public String confirmation(ModelMap model, @SessionAttribute(value = "user", required = false) User user,
			@SessionAttribute(value = "cart", required = false) Cart cart) {
		OrderDAO orderDAO = new OrderDAO();
		if (cart == null || user == null) {
			model.addAttribute("message", "Для покупки нужно авторизоваться");
			return "confirm";
		}
		List<Order> orderList = new ArrayList<>();
		for (Order prod : cart.getProducts()) {
			if (prod.getUsername() == null) {
				prod.setUsername(user.getName());
				prod.setUser_email(user.getEmail());
				prod.setUser_phonenumber(user.getPhonenumber());
			}
			orderDAO.add(prod); // SAVE IN DAO
			orderList.add(prod);  // ADD TO THE ARRAY
		}
		
		Date dateNow = new Date();
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd ' ' hh:mm:ss a zzz");

		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put(EmailService.FROM, "maksim12288@gmail.com");
		velocityContext.put(EmailService.SUBJECT, "Магазин детской обуви|Oliinyk Store");
		velocityContext.put(EmailService.TO, user.getEmail());
		velocityContext.put(EmailService.CCC_LIST, new ArrayList<>());
		velocityContext.put(EmailService.BCC_LIST, new ArrayList<>());
		velocityContext.put("date", formatForDateNow.format(dateNow));
		velocityContext.put("myurl", "www.google.com.ua");
		velocityContext.put("orders", orderList);
		boolean rr = emailService.sendEmail("registered.vm", velocityContext);
		cart.getProducts().clear();
		model.addAttribute("message", "Товар приобретен " + rr + "");
		return "confirm";
	}
}
