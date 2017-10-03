package itea.ua.oliinyk.dao;

import itea.ua.oliinyk.entity.Product;

public class ProductDAO extends AbstractDAO<Product> {

	public ProductDAO() {
		super();
	}

/*	public List<Product> getProductsByGender(String gender) {
		List<Product> result = getEntityManager().createNamedQuery("Product.getProdByGender", Product.class)
				.setParameter("gender", gender).getResultList();
		return result;
	}*/

}
