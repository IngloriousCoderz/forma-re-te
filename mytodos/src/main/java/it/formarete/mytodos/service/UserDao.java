package it.formarete.mytodos.service;

import it.formarete.mytodos.model.User;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
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

	public void delete(String name) {
		User user = get(name);
		delete(user);
	}

	public void deleteHQL(String name) {
		User user = get(name);
		sessionFactory.getCurrentSession()
						.createQuery("delete from Todo where owner_id = :id")
						.setParameter("id", user.getId()).executeUpdate();
		sessionFactory.getCurrentSession()
						.createQuery("delete from User where name = :name")
						.setParameter("name", name).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(User.class).list();
	}

	public void clear() {
		sessionFactory.getCurrentSession().createQuery("delete from Todo")
						.executeUpdate();
		sessionFactory.getCurrentSession().createQuery("delete from User")
						.executeUpdate();
	}
}
