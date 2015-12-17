package com.fourjva.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class JpaDao<E,K extends Serializable> implements Dao<E, K> {
	protected Class<E> entity;
	@PersistenceContext
	protected EntityManager manager;
	
	public JpaDao() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entity = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
	}

	@Override
	public E persist(E entity) {
		this.manager.persist(entity);
		return entity;
	}

	@Override
	public void remove(E entity) {
		this.manager.remove(entity);
	}
	
	@Override
	public E update(E entity) {
		this.manager.merge(entity);
		return entity;
	}

	@Override
	public E findById(K id) {
		E e = this.manager.find(this.entity, id);
		return e;
	}
}
