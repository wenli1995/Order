package com.java.dao;

import java.io.Serializable;
import java.util.List;

import com.java.entity.User;

public interface BaseDao<T> {
		
		public void save(T o);
		public void update(T o);
		public void delete(T o);
		public List<T> query(String hql);
		public T get(Class<T> c, Serializable id);
		public T get(String hql, Object[] param);
}
