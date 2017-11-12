package itea.ua.oliinyk.controllers;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import itea.ua.oliinyk.dao.BrandDAO;
import itea.ua.oliinyk.dao.CategoryDAO;
import itea.ua.oliinyk.dao.GenderDAO;
import itea.ua.oliinyk.dao.Liner_Material_DAO;
import itea.ua.oliinyk.dao.ProductDAO;
import itea.ua.oliinyk.dao.SizeDAO;
import itea.ua.oliinyk.dao.Upper_Material_DAO;
import itea.ua.oliinyk.entity.Product;
import itea.ua.oliinyk.entity.categories.Brand;
import itea.ua.oliinyk.entity.categories.Category;
import itea.ua.oliinyk.entity.categories.Gender;
import itea.ua.oliinyk.entity.categories.Liner_Material;
import itea.ua.oliinyk.entity.categories.Size;
import itea.ua.oliinyk.entity.categories.Upper_Material;

@Controller
public class ProductController {
	private final String genderIdBoy = "boy";
	private final String genderIdGirl = "girl";

	@RequestMapping(value = "/stuff", method = RequestMethod.GET)
	public String doGetPage(ModelMap model) {
		String url;
		ProductDAO prodDAO = new ProductDAO();
		List<Product> products = prodDAO.getListAll(Product.class);
		model.addAttribute("products", products);

		setValuesForFilter(model, products);

		url = "stuff";
		return url;
	}

	@RequestMapping(value = "/stuff", params = "genderId", method = RequestMethod.GET)
	public String getStuffByGender(ModelMap model, @RequestParam("genderId") String genderId) {
		String url;
		Gender genders = new GenderDAO().getCategoryById(genderId);
		ProductDAO prodDAO = new ProductDAO();
		List<Product> products = prodDAO.getProductsByGender(genders);
		model.addAttribute("products", products);
		
		setValuesForFilter(model, products);

		url = "stuff";
		return url;
	}

	@RequestMapping(value = "/stuff", params = "brandId", method = RequestMethod.GET)
	public String getStuffByBrand(ModelMap model, @RequestParam("brandId") String brandId) {
		String url;
		BrandDAO brandDao = new BrandDAO();
		ProductDAO prodDAO = new ProductDAO();
		Brand brand = brandDao.getBrandById(brandId);
		List<Product> products = prodDAO.getProductsByBrand(brand);
		model.addAttribute("products", products);

		setValuesForFilter(model, products);

		url = "/stuff";
		return url;
	}

	@RequestMapping(value = "/stuff", params = "categoryId", method = RequestMethod.GET)
	public String getStuffByCategory(ModelMap model, @RequestParam("categoryId") String categoryId) {
		String url;
		Category category = new CategoryDAO().getCategoryById(categoryId);
		ProductDAO prodDAO = new ProductDAO();
		List<Product> products = prodDAO.getProductsByCategory(category);
		model.addAttribute("products", products);

		setValuesForFilter(model, products);

		url = "stuff";
		return url;
	}
	
	@RequestMapping(value = "/stuff", params = "sizeId", method = RequestMethod.GET)
	public String getStuffBySize(ModelMap model, @RequestParam("sizeId") Integer sizeId) {
		String url;
		Size size = new SizeDAO().getSizeById(sizeId);
		ProductDAO prodDAO = new ProductDAO();
		List<Product> products = prodDAO.getProductsBySize(size);
		model.addAttribute("products", products);

		setValuesForFilter(model, products);

		url = "stuff";
		return url;
	}

	@RequestMapping(value = "/stuff", params = "upperId", method = RequestMethod.GET)
	public String getStuffByUM(ModelMap model, @RequestParam("upperId") String upperId) {
		String url;
		Upper_Material uppMat = new Upper_Material_DAO().getUMById(upperId);
		ProductDAO prodDAO = new ProductDAO();
		List<Product> products = prodDAO.getProductsByUM(uppMat);
		model.addAttribute("products", products);

		setValuesForFilter(model, products);

		url = "stuff";
		return url;
	}

	@RequestMapping(value = "/stuff", params = "linerId", method = RequestMethod.GET)
	public String getStuffByLM(ModelMap model, @RequestParam("linerId") String linerId) {
		String url;
		Liner_Material linMat = new Liner_Material_DAO().getLMById(linerId);
		ProductDAO prodDAO = new ProductDAO();
		List<Product> products = prodDAO.getProductsByLM(linMat);
		model.addAttribute("products", products);

		setValuesForFilter(model, products);

		url = "stuff";
		return url;
	}

	@RequestMapping(value = "/stuff", params = { "genderId", "brandId" }, method = RequestMethod.GET)
	public String getStuffGenderBrand(ModelMap model, @RequestParam("genderId") String genderId,
			@RequestParam("brandId") String brandId) {
		String url;
		Brand brand = new BrandDAO().getBrandById(brandId);
		Gender gender = new GenderDAO().getCategoryById(genderId);
		ProductDAO prodDAO = new ProductDAO();
		List<Product> products = prodDAO.getProductsByBrandAndGender(gender, brand);
		model.addAttribute("products", products);
		
		setValuesForFilter(model, products);
		
		url = "stuff";
		return url;
	}

	@RequestMapping(value = "/for_boy", method = RequestMethod.GET)
	public String getStuffForBoy(ModelMap model) {
		String url;
		Gender gender = new GenderDAO().getCategoryById(genderIdBoy);
		ProductDAO prodDAO = new ProductDAO();
		List<Product> products = prodDAO.getProductsByGender(gender);
		model.addAttribute("products", products);
		url = "for_boy";
		return url;
	}

	@RequestMapping(value = "/for_girl", method = RequestMethod.GET)
	public String getStuffForGirl(ModelMap model) {
		String url;
		Gender gender = new GenderDAO().getCategoryById(genderIdGirl);
		ProductDAO prodDAO = new ProductDAO();
		List<Product> products = prodDAO.getProductsByGender(gender);
		model.addAttribute("products", products);
		url = "for_girl";
		return url;
	}

	private void setValuesForFilter(ModelMap model, List<Product> products) {
		Set<Brand> brands = new TreeSet<>();
		for (Product pr : products) {
			brands.add(pr.getBrand());
		}
		model.addAttribute("brands", brands);

		Set<Category> categories = new TreeSet<>();
		for (Product pr : products) {
			categories.add(pr.getCategories());
		}
		model.addAttribute("categories", categories);

		Set<Gender> gender = new TreeSet<>();
		for (Product pr : products) {
			gender.add(pr.getGenders());
		}
		model.addAttribute("gender", gender);
		
		Set<Size> size = new TreeSet<>();
		for (Product pr : products) {
			for(Size s: pr.getSize()) {
				size.add(s);
			}
		}
		model.addAttribute("size", size);

		Set<Liner_Material> lm = new TreeSet<>();
		for (Product pr : products) {
			lm.add(pr.getLiner_material());
		}
		model.addAttribute("lm", lm);

		Set<Upper_Material> um = new TreeSet<>();
		for (Product pr : products) {
			um.add(pr.getUpper_material());
		}
		model.addAttribute("um", um);
	}

}
