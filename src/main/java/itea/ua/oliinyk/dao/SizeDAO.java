package itea.ua.oliinyk.dao;

import itea.ua.oliinyk.entity.categories.Size;

public class SizeDAO extends AbstractDAO<Size> {
	public SizeDAO() {
		super();
	}

	public Size getBrandById(String id) {
		return super.getEntityById(Size.class, id);
	}

}