package com.xhc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xhc.entity.Users;
import com.xhc.utils.HibernateUtils;

public class UsersDao {
	public UsersDao() {

	}

	public void save(Users entity) {
		HibernateUtils.getSession().save(entity);
	}

	public void delete(Integer id) {
		// 这样写为什么不可以？
		// HibernateUtils.getSession().delete(id);
		Transaction tx = null;
		Session session = null;
		session = HibernateUtils.getSession();
		String sql = "delete from Users where id=?";
		Query query = session.createQuery(sql);
		query.setInteger(0, id);
		query.executeUpdate();
	}

	public Users get(Integer id) {
		return (Users) HibernateUtils.getSession().get(Users.class, id);
	}

	public List<Users> findAll() {
		String sql = "from Users";
		return HibernateUtils.getSession().createQuery(sql).list();
	}

	public Users findByName(String username) {

		/*
		 * String hql="from Users where user_name=?";
		 * 
		 * return (Users) HibernateUtils.getSession().createQuery(hql);
		 */

		Transaction tx = null;
		Session session = null;
		session = HibernateUtils.getSession();
		String sql =" from Users where user_name=?";
		Query query = session.createQuery(sql);
		query.setString(0, username);
		List<Users> list = query.list();
		Users user = new Users();
		for (Users u : list) {
			user = u;
		}
		return user;
	}

}
