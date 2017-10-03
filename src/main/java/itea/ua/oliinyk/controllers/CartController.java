package itea.ua.oliinyk.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import itea.ua.oliinyk.entity.Cart;
import itea.ua.oliinyk.entity.User;
import itea.ua.oliinyk.orders.Order;

@Controller
@RequestMapping("/addTocart")
@SessionAttributes("cart")
public class CartController {

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String addProductToCart(ModelMap model, @RequestParam("product") String json) {

		Cart cart = (Cart) model.get("cart");
		User user = (User) model.get("user");
		if (cart == null) {
			cart = new Cart();
		}

		Date dateNow = new Date();
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd ' ' hh:mm:ss a zzz");

		Order order_product = new Order();
		JSONObject jsonObj = new JSONObject(json);
		order_product.setProduct_id(jsonObj.getInt("id"));
		order_product.setProduct_brand(jsonObj.getString("brand"));
		order_product.setProduct_model(jsonObj.getString("model"));
		order_product.setProduct_size(jsonObj.getInt("size"));
		order_product.setProduct_price(jsonObj.getInt("price"));
		order_product.setDate(formatForDateNow.format(dateNow));
		if(user != null) {
			order_product.setUsername(user.getName());
			order_product.setUser_email(user.getEmail());
			order_product.setUser_phonenumber(user.getPhonenumber()); 
		}

		if (cart.getProducts().contains(order_product)) {
			order_product = cart.getProducts().get(cart.getProducts().indexOf(order_product));
			order_product.setProduct_quantity(order_product.getProduct_quantity() + 1);
		} else {
			order_product.setProduct_quantity(1);
			cart.getProducts().add(order_product);
		}

		model.addAttribute("cart", cart);

		JSONObject response = new JSONObject();
		response.put("totalItems", cart.getTotalItems());
		response.put("totalAmount", cart.getTotalAmount());

		return response.toString();
	}

}