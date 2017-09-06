package itea.ua.oliinyk.dao;

import itea.ua.oliinyk.entity.User;

public class UserDAO extends AbstractDAO<User> {

	public UserDAO() {
		super();
	}

	public Integer create(User user) {
		getEntityTransaction().begin();
		getEntityManager().persist(user);
		getEntityTransaction().commit();
		return user.getId();
	}

	public User getUser(String login, String password) {
		User user = getEntityManager().createNamedQuery("User.getUserByLogAndPSW", User.class)
				.setParameter("login", login).setParameter("password", password).getSingleResult();
		return user;
	}

	public User isUserExist(String login, String email) {
		User user = getEntityManager().createNamedQuery("User.getUserByLogAndEmail", User.class)
				.setParameter("login", login).setParameter("email", email).getSingleResult();
		return user;
	}

	public User getUser(String login) {
		User user = getEntityManager().createNamedQuery("User.getByLog", User.class).setParameter("login", login)
				.getSingleResult();
		return user;
	}

}
