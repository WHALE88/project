package itea.ua.oliinyk.dao;

import itea.ua.oliinyk.entity.categories.Brand;

public class BrandDAO extends AbstractDAO<Brand> {
	public BrandDAO() {
		super();
	}
	
	public Brand getBrandById(String id) {
        return super.getEntityById(Brand.class, id);
    }

}
