package com.jkxy.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jkxy.entity.Poetries;
import com.jkxy.utils.HibernateUtils;

public class UserService {
	/**
	 * 根据诗人名字查询诗词数量
	 * 
	 * @param name
	 *            诗人名
	 * @return
	 */
	public void getCountByName(String name) {
		int count = getCount(name);
		if (count > 0) {
			System.out.println("*******************************");
			System.out.println("你输入的诗人姓名：" + name + ",诗词数量:" + count + "条记录。");
		} else {
			System.out.println("*******************************");
			System.out.println("没有查到信息！");
		}
	}

	/**
	 * 根据诗人名获取诗人诗词名称记录
	 * 
	 * @param name
	 *            诗人名
	 * @return 诗词名称总数
	 */
	private int getCount(String name) {
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			String hql = " select count(b.title)from Poets a,Poetries b where a.id=b.poet_id and name=?";
			Query query = session.createQuery(hql);
			query.setString(0, name);
			List list = query.list();
			tx.commit();
			return Integer.valueOf(list.get(0).toString());
		} catch (HibernateException he) {
			if (tx != null) {
				tx.rollback();
			}
			he.printStackTrace();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return 0;
	}

	/**
	 * 分页查询
	 * 
	 * @param pageNo
	 *            页号
	 * @param name
	 *            诗人名
	 * @return Poetries 集合
	 */
	private List<Poetries> getPage(int pageNo, String name) {
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			String hql = "select b from Poets a,Poetries b where a.id=b.poet_id and a.name=?";
			Query query = session.createQuery(hql).setFirstResult(pageNo * 10).setMaxResults(10);
			query.setString(0, name);
			List<Poetries> list = query.list();
			tx.commit();
			return list;
		} catch (HibernateException he) {
			if (tx != null) {
				tx.rollback();
			}
			he.printStackTrace();
		} finally {
			HibernateUtils.closeSession(session);
		}
		return null;
	}

	/**
	 * 实现分页查询
	 */
	public void getPager(String name) {
		int count = getCount(name);
		if (count > 0) {
			int last = count%10==10?count / 10 :count / 10 + 1;
			System.out.println("*******************************");
			System.out.println(name + "共" + last + "页");
			for (int i = 0; i < last; i++) {
				List<Poetries> list = getPage(i, name);
				System.out.println("第" + (i + 1) + "页内容");
				for (Poetries ps : list) {
					System.out.println("《" + ps.getTitle() + "》");
				}
			}
		/*	List<Poetries> lastPage = getPage((last - 1), name);
			System.out.println("第" + last + "页内容(最后一页内容)");
			for (Poetries ps : lastPage) {
				System.out.println("《" + ps.getTitle() + "》");
			}*/
		} else {
			System.out.println("*******************************");
			System.out.println("无相关信息！");
		}
	}
	/**
	 * 通过诗人名，查询诗词内容前15个字
	 * @param name 诗人名
	 */
	public void byContent(String name) {
		if (getCount(name) > 0) {
			Transaction tx = null;
			Session session = null;
			try {
				session = HibernateUtils.getSession();
				tx = session.beginTransaction();
				String hql = "select b.content from Poets a,Poetries b  where a.id=b.poet_id and a.name=?";
				Query query = session.createQuery(hql);
				query.setString(0, name);
				List<String> list = query.list();
				System.out.println("*******************************");
				for (String str : list) {
					if (str.length() < 15) {
						System.out.println(str);
					} else {
						System.out.println(str.substring(0, 15) + " ....");
					}
				}
				tx.commit();
			} catch (HibernateException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else {
			System.out.println("*******************************");
			System.out.println("无相关信息！");
		}
	}
}
