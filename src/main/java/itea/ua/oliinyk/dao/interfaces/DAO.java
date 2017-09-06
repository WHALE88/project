package itea.ua.oliinyk.dao.interfaces;

import java.util.List;

import itea.ua.oliinyk.entity.ShopEntity;

public interface DAO<E extends ShopEntity> {
	E add(E entity);

	void delete(Class<E> entityClass, int id);

	E getEntityById(Class<E> entityClass, int id);

	List<E> getListAll(Class<E> entityClass);

	void close();
}
