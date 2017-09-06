package itea.ua.oliinyk.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import itea.ua.oliinyk.dao.ProductDAO;
import itea.ua.oliinyk.entity.Product;

@Controller
@RequestMapping(value = "/stuff")
public class ProductController {
	@RequestMapping(method = RequestMethod.GET)
	public String doGetPage(ModelMap model) {
		String url;
		ProductDAO prodDAO = new ProductDAO();
		List<Product> products = prodDAO.getListAll(Product.class);
		model.addAttribute("products", products);
		url = "stuff";
		return url;
	}
}
