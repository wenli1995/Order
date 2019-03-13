package com.java.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.dao.BaseDao;

@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {

	private  SessionFactory sessionFactory;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(T o) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(o);
	}

	@Override
	public void update(T o) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(o);
	}

	@Override
	public void delete(T o) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(o);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> query(String hql) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	@Override
	public T get(Class<T> c, Serializable id) {
		// TODO Auto-generated method stub
		return (T) sessionFactory.getCurrentSession().get(c, id);
	}
	
	@Override
	public T get(String hql, Object[] param) {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		List<T> l=q.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}
}
