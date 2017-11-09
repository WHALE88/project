package itea.ua.oliinyk.dao;

import java.util.List;

import itea.ua.oliinyk.entity.Product;
import itea.ua.oliinyk.entity.categories.Brand;
import itea.ua.oliinyk.entity.categories.Gender;

public class ProductDAO extends AbstractDAO<Product> {

	public ProductDAO() {
		super();
	}
	
    public List<Product> getProductsByGender(Gender gender) {
        List<Product> result = getEntityManager()
                .createNamedQuery("Product.getProdByGender", Product.class)
                .setParameter("gender", gender)
                .getResultList();
        return result;
    }
    
    public List<Product> getProductsByBrand(Brand brand) {
        List<Product> result = getEntityManager()
                .createNamedQuery("Product.getProdByBrand", Product.class)
                .setParameter("brand", brand)
                .getResultList();
        return result;
    }
    
    public List<Product> getProductsByBrandAndGender(Gender gender, Brand brand) {
        List<Product> result = getEntityManager()
                .createNamedQuery("Product.getProdByGender&Brand", Product.class)
                .setParameter("brand", brand).setParameter("gender", gender)
                .getResultList();
        return result;
    }

}
