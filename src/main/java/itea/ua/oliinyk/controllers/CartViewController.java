package itea.ua.oliinyk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import itea.ua.oliinyk.dao.OrderDAO;
import itea.ua.oliinyk.entity.Cart;
import itea.ua.oliinyk.entity.User;
import itea.ua.oliinyk.orders.Order;

@Controller
public class CartViewController {
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
		for (Order prod : cart.getProducts()) {
			if (prod.getUsername() == null) {
				prod.setUsername(user.getName());
				prod.setUser_email(user.getEmail());
				prod.setUser_phonenumber(user.getPhonenumber());
			}
			orderDAO.add(prod);
		}
		cart.getProducts().clear();
		model.addAttribute("message", "Товар приобретен");
		return "confirm";
	}
}
