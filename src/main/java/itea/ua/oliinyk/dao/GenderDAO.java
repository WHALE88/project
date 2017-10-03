package itea.ua.oliinyk.dao;

import java.util.List;

import itea.ua.oliinyk.entity.categories.Gender;

public class GenderDAO extends AbstractDAO<Gender> {
	public GenderDAO() {
	}
	
	public Gender getCategoryById(String id) {
        return super.getEntityById(Gender.class, id);
    }

    public List<Gender> getAll() {
        return getListAll(Gender.class);
    }
}
