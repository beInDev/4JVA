package com.fourjva.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;

public abstract class JpaDao<E> {
	protected Class<E> entity;
	@PersistenceContext
	protected EntityManager manager;
	
	public JpaDao(Class<E> entityClass) {
		this.entity = entityClass;
	}

	public E persist(E entity) {
		this.manager.persist(entity);
		return entity;
	}

	public void remove(E entity) {
		this.manager.remove(entity);
	}

	public E update(E entity) {
		this.manager.merge(entity);
		return entity;
	}

	public E findById(int id) {
		E e = this.manager.find(this.entity, id);
		return e;
	}
}
