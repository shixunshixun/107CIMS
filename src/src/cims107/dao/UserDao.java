package cims107.dao;

import java.util.List;

import cims107.model.User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDao {

private SessionFactory sessionFactory;
	
	public User find(String name, String password) {
		Session session = sessionFactory.openSession();
		String hql = "FROM User AS u WHERE u.userName = :name AND u.userPassword = :password";
		Query q = session.createQuery(hql);
		q.setString("name", name);
		q.setString("password", password);
		List<User> list = q.list();
		session.close();
		if (list.size()==0)
			return null;
		else
			return list.get(0);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User find(User user) {
		return find(user.getUserName(),user.getUserPassword());
	}
}
