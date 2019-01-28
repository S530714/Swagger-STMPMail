package com.example.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO implements IUserDAO {

	@Override
	public UserModel getUserById(int Id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session  session = sessionFactory.openSession();
		UserModel user = session.get(UserModel.class, Id);
		session.close();
		return user;
	}

	@Override
	public List<UserModel> getAllUsers() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session  session = sessionFactory.openSession();
		List<UserModel> users = (List<UserModel>) session.createQuery("from UserModel").list();
		session.close();
		return users;
	}

	@Override
	public boolean addUser(UserModel newUser) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session  session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(newUser);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean updateUser(UserModel user) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session  session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteUser(int userId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session  session = sessionFactory.openSession();
		UserModel user = this.getUserById(userId);
		session.beginTransaction();
		session.delete(user);
		session.getTransaction().commit();
		session.close();
		return false;
	}

	@Override
	public boolean findByFirstName(String firstName) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session  session = sessionFactory.openSession();
		session.beginTransaction();
		List<UserModel> users = (List<UserModel>) session.createQuery("select u from User u where u.firstName = '"+firstName+"'").list();
		session.getTransaction().commit();
		session.close();
		return users.isEmpty();
	}

}
