package itea.ua.oliinyk.dao;

import java.util.List;

import itea.ua.oliinyk.entity.Product;
import itea.ua.oliinyk.entity.categories.Brand;
import itea.ua.oliinyk.entity.categories.Category;
import itea.ua.oliinyk.entity.categories.Gender;
import itea.ua.oliinyk.entity.categories.Liner_Material;
import itea.ua.oliinyk.entity.categories.Size;
import itea.ua.oliinyk.entity.categories.Upper_Material;

public class ProductDAO extends AbstractDAO<Product> {

	public ProductDAO() {
		super();
	}

	public List<Product> getProductsByGender(Gender gender) {
		List<Product> result = getEntityManager().createNamedQuery("Product.getProdByGender", Product.class)
				.setParameter("gender", gender).getResultList();
		return result;
	}

	public List<Product> getProductsByBrand(Brand brand) {
		List<Product> result = getEntityManager().createNamedQuery("Product.getProdByBrand", Product.class)
				.setParameter("brand", brand).getResultList();
		return result;
	}

	public List<Product> getProductsByCategory(Category category) {
		List<Product> result = getEntityManager().createNamedQuery("Product.getProdByCategory", Product.class)
				.setParameter("category", category).getResultList();
		return result;
	}

	public List<Product> getProductsByLM(Liner_Material lm) {
		List<Product> result = getEntityManager().createNamedQuery("Product.getProdByLinMat", Product.class)
				.setParameter("liner_material", lm).getResultList();
		return result;
	}

	public List<Product> getProductsBySize(Size size) {
		List<Product> result = getEntityManager().createNamedQuery("Product.getProdBySize", Product.class)
				.setParameter("size", size).getResultList();
		return result;
	}

	public List<Product> getProductsByUM(Upper_Material um) {
		List<Product> result = getEntityManager().createNamedQuery("Product.getProdByUpMat", Product.class)
				.setParameter("upper_material", um).getResultList();
		return result;
	}

	public List<Product> getProductsByBrandAndGender(Gender gender, Brand brand) {
		List<Product> result = getEntityManager().createNamedQuery("Product.getProdByGender&Brand", Product.class)
				.setParameter("brand", brand).setParameter("gender", gender).getResultList();
		return result;
	}

}
