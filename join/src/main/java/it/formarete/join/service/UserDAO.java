package it.formarete.join.service;

import it.formarete.join.model.User;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User get(int id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	public User get(String name) {
		return (User) sessionFactory.getCurrentSession()
						.createQuery("from User where name = :name").setParameter("name", name)
						.uniqueResult();
	}

	public int save(User user) {
		return (Integer) sessionFactory.getCurrentSession().save(user);
	}

	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	public void deleteByName(String name) {
		User user = get(name);
		delete(user);
	}

	public void deleteByNameHQL(String name) {
		sessionFactory.getCurrentSession()
						.createQuery("delete from User where name = :name")
						.setParameter("name", name).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public void clear() {
		sessionFactory.getCurrentSession().createQuery("delete from User")
						.executeUpdate();
	}
}
