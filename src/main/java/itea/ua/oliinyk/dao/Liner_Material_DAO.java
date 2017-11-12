package itea.ua.oliinyk.dao;

import itea.ua.oliinyk.entity.categories.Liner_Material;

public class Liner_Material_DAO extends AbstractDAO<Liner_Material> {
	public Liner_Material_DAO() {
		super();
	}

	public Liner_Material getLMById(String id) {
		return super.getEntityById(Liner_Material.class, id);
	}

}
