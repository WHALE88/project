package itea.ua.oliinyk.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import itea.ua.oliinyk.dao.BrandDAO;
import itea.ua.oliinyk.dao.GenderDAO;
import itea.ua.oliinyk.dao.ProductDAO;
import itea.ua.oliinyk.entity.Product;
import itea.ua.oliinyk.entity.categories.Brand;
import itea.ua.oliinyk.entity.categories.Gender;

@Controller
public class ProductController {
	private final String genderIdBoy = "boy";
	private final String genderIdGirl = "girl";
	
	@RequestMapping(value="/stuff", method = RequestMethod.GET)
	public String doGetPage(ModelMap model) {
		String url;
		ProductDAO prodDAO = new ProductDAO();
		List<Product> products = prodDAO.getListAll(Product.class);
		model.addAttribute("products", products);
		url = "stuff";
		return url;
	}
	
	
	@RequestMapping(value="/stuff", params = "genderId",  method = RequestMethod.GET)
	public String getStuffByGender(ModelMap model, @RequestParam("genderId") String genderId) {
		String url;
		Gender gender = new GenderDAO().getCategoryById(genderId);
		ProductDAO prodDAO = new ProductDAO();
		List<Product> products = prodDAO.getProductsByGender(gender);
		model.addAttribute("products", products);
		url = "stuff";
		return url;
	}
	
	@RequestMapping(value="/stuff", params = "brandId",  method = RequestMethod.GET)
	public String getStuffByBrand(ModelMap model, @RequestParam("brandId") String brandId) {
		String url;
		Brand brand = new BrandDAO().getBrandById(brandId);
		ProductDAO prodDAO = new ProductDAO();
		List<Product> products = prodDAO.getProductsByBrand(brand);
		model.addAttribute("products", products);
		url = "stuff";
		return url;
	}
	
	@RequestMapping(value="/stuff", params = {"genderId", "brandId"},  method = RequestMethod.GET)
	public String getStuffGenderBrand(ModelMap model, @RequestParam("genderId") String genderId,
			@RequestParam("brandId") String brandId) {
		String url;
		Brand brand = new BrandDAO().getBrandById(brandId);
		Gender gender = new GenderDAO().getCategoryById(genderId);
		ProductDAO prodDAO = new ProductDAO();
		List<Product> products = prodDAO.getProductsByBrandAndGender(gender, brand);
		model.addAttribute("products", products);
		url = "stuff";
		return url;
	}
	
	@RequestMapping(value="/for_boy", method = RequestMethod.GET)
	public String getStuffForBoy(ModelMap model) {
		String url;
		Gender gender = new GenderDAO().getCategoryById(genderIdBoy);
		ProductDAO prodDAO = new ProductDAO();
		List<Product> products = prodDAO.getProductsByGender(gender);
		model.addAttribute("products", products);
		url = "for_boy";
		return url;
	}
	
	
	@RequestMapping(value="/for_girl", method = RequestMethod.GET)
	public String getStuffForGirl(ModelMap model) {
		String url;
		Gender gender = new GenderDAO().getCategoryById(genderIdGirl);
		ProductDAO prodDAO = new ProductDAO();
		List<Product> products = prodDAO.getProductsByGender(gender);
		model.addAttribute("products", products);
		url = "for_girl";
		return url;
	}

}
