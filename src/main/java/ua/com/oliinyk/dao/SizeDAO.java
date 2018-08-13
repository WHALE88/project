package ua.com.oliinyk.dao;

import ua.com.oliinyk.entity.categories.Size;

public class SizeDAO extends AbstractDAO<Size> {
	public SizeDAO() {
		super();
	}

	public Size getSizeById(Integer id) {
		return super.getEntityById(Size.class, id);
	}

}