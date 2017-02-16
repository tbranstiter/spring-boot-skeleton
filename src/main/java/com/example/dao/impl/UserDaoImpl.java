package com.example.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserDao;
import com.example.dto.User;



@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	
	@Autowired private SessionFactory sessionFactory;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return this.sessionFactory.openSession().createQuery("from User").list();
	}
	
	@Override
	public void save(User user) {
		Session session = sessionFactory.openSession();
		session.save(user);
	}
	
	@Override
	public User getUserById(long id) {
		Query q = this.sessionFactory.openSession().createQuery("from User as u where u.id = :id");
		q.setParameter("id", id);
		return (User) q.uniqueResult();
	}
	
	@Override
	public void updateUser(User user) {
		Query q = this.sessionFactory.openSession().createQuery("update User as u set u.password = :password where u.id = :id");
		q.setParameter("id", user.getId());
		q.setParameter("password", user.getPassword());
		q.executeUpdate();
	}
	
	@Override
	public void deleteUserById(long id) {
		Query q = this.sessionFactory.openSession().createQuery("delete from User as u where u.id = :id");
		q.setParameter("id", id);
		q.executeUpdate();
	}
}
