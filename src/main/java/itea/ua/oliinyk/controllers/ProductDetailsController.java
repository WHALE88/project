package itea.ua.oliinyk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import itea.ua.oliinyk.dao.ProductDAO;
import itea.ua.oliinyk.entity.Product;

@Controller
@RequestMapping(value="/productdetail")
public class ProductDetailsController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGetPage(@RequestParam("prodId") int id, ModelMap model) {
		String url;
		ProductDAO prodDAO = new ProductDAO();
		Product product = prodDAO.getEntityById(Product.class, id);
		model.addAttribute("product", product);
		url = "productdetail";
		return url;
	}
}
