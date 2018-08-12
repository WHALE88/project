package ua.com.oliinyk.dao;

import ua.com.oliinyk.entity.categories.Category;

public class CategoryDAO extends AbstractDAO<Category> {
	public CategoryDAO() {
		super();
	}
	
	public Category getCategoryById(String id) {
        return super.getEntityById(Category.class, id);
    }
}
