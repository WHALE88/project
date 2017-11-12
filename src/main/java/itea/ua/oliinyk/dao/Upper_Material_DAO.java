package itea.ua.oliinyk.dao;

import itea.ua.oliinyk.entity.categories.Upper_Material;

public class Upper_Material_DAO extends AbstractDAO<Upper_Material> {
	public Upper_Material_DAO() {
		super();
	}

	public Upper_Material getUMById(String id) {
		return super.getEntityById(Upper_Material.class, id);
	}

}