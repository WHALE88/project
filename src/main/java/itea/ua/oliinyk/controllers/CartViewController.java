package itea.ua.oliinyk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String confirmation(ModelMap model) {
		Cart cart = (Cart) model.get("cart");
		User user = (User) model.get("user");
		OrderDAO orderDAO = new OrderDAO();
		if (cart != null && user != null)
			for (Order prod : cart.getProducts()) {
				orderDAO.add(prod);
			}

		else {
			model.addAttribute("message", "Для покупки нужно авторизоваться");
		}
		return "confirm";
	}
}
