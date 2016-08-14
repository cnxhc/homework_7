package com.xhc.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xhc.dao.UsersDao;
import com.xhc.entity.Users;
import com.xhc.utils.HibernateUtils;

public class UsersService {
	UsersDao userDao = new UsersDao();

	/**
	 * 根据用户主键删除用户信息
	 * 
	 * @param id
	 *            主键
	 */
	public void delete(Integer id) {
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			userDao.delete(id);
			tx.commit();
		} catch (HibernateException he) {
			if (tx != null) {
				tx.rollback();
			}
			he.printStackTrace();
		} finally {
			HibernateUtils.closeSession(session);
		}
	}

	/**
	 * 查找所有用户信息
	 * 
	 * @return
	 */
	public List<Users> findAll() {
		Transaction tx = null;
		Session session = null;
		List<Users> list = new ArrayList<>();
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			list = userDao.findAll();
			tx.commit();
		} catch (HibernateException he) {
			if (tx != null) {
				tx.rollback();
			}
			he.printStackTrace();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return list;
	}

	/**
	 * 向数据库插入用户信息
	 * 
	 * @param entity
	 *            实体类
	 */
	public void save(Users entity) {
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			userDao.save(entity);
			tx.commit();
		} catch (HibernateException he) {
			if (tx != null) {
				tx.rollback();
			}
			he.printStackTrace();
		} finally {
			HibernateUtils.closeSession(session);
		}
	}

	/**
	 * 根据主键查询用户信息
	 * 
	 * @param id
	 *            主键
	 * @return 用户实体类
	 */
	public Users get(Integer id) {
		Transaction tx = null;
		Session session = null;
		Users user = new Users();
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			user = userDao.get(id);
			tx.commit();
		} catch (HibernateException he) {
			if (tx != null) {
				tx.rollback();
			}
			he.printStackTrace();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return user;
	}

	/**
	 * 通过用户名查询
	 * 
	 * @param username
	 *            用户名
	 * @return 用户对象
	 */
	public Users findByName(String username) {
		Transaction tx = null;
		Session session = null;
		Users user = new Users();
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			user = userDao.findByName(username);
			tx.commit();
		} catch (HibernateException he) {
			if (tx != null) {
				tx.rollback();
			}
			he.printStackTrace();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return user;
	}
}
