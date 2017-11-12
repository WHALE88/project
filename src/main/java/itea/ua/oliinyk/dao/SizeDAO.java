package itea.ua.oliinyk.dao;

import itea.ua.oliinyk.entity.categories.Size;

public class SizeDAO extends AbstractDAO<Size> {
	public SizeDAO() {
		super();
	}

	public Size getSizeById(Integer id) {
		return super.getEntityById(Size.class, id);
	}

}