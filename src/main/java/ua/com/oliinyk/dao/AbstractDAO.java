package ua.com.oliinyk.dao;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import ua.com.oliinyk.dao.interfaces.DAO;
import ua.com.oliinyk.entity.ShopEntity;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@Slf4j(topic = "abstractDao")
public abstract class AbstractDAO<E extends ShopEntity> implements DAO<E> {

  @Resource
	private SessionFactory sessionFactory;

	public AbstractDAO() {
	}

	EntityManager getEntityManager() {
	  log.info("get current session");
		return sessionFactory.getCurrentSession();
	}

	EntityTransaction getEntityTransaction() {
    log.info("get transaction manager");
    return getEntityManager().getTransaction();
	}

	@Override
	public void close() {
		if (sessionFactory != null) {
			sessionFactory.close();
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
