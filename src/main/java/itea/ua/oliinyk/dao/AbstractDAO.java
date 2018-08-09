package itea.ua.oliinyk.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import itea.ua.oliinyk.dao.interfaces.DAO;
import itea.ua.oliinyk.entity.ShopEntity;

public abstract class AbstractDAO<E extends ShopEntity> implements DAO<E> {

	private final String PERSISTENCE_UNIT_NAME = "myEntityManager";
	private EntityManager em;

	public AbstractDAO() {
		em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	}

	EntityManager getEntityManager() {
		return em;
	}

	EntityTransaction getEntityTransaction() {
		return em.getTransaction();
	}

	@Override
	public void close() {
		if (em != null) {
			em.close();
		}
	}

	@Override
	public E add(E entity) {
		getEntityTransaction().begin();
		E en = getEntityManager().merge(entity);
		getEntityTransaction().commit();
		return en;
	}

	@Override
	public void delete(Class<E> entityClass, int id) {
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(getEntityById(entityClass, id));
		getEntityManager().getTransaction().commit();
	}

	@Override
	public E getEntityById(Class<E> entityClass, int id) {
		return getEntityManager().find(entityClass, id);
	}
	
	@Override
	public E getEntityById(Class<E> entityClass, String id) {
		return getEntityManager().find(entityClass, id);
	}

	@Override
	public List<E> getListAll(Class<E> entityClass) {
		return getEntityManager().createNamedQuery(entityClass.getSimpleName() + ".All", entityClass)
				.getResultList();
	}

}
