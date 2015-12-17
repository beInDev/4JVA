package com.fourjva.dao.base;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import javax.ejb.Stateless;
import javax.naming.InitialContext;

@Stateless
public abstract class JpaDao<E> {
	protected Class<E> entity;
	@PersistenceUnit(unitName="4JV")
	protected EntityManagerFactory factory;
	
	protected UserTransaction transaction;
	
	protected EntityManager getEntityManager(){
		return factory.createEntityManager();
	}
	
	public JpaDao(Class<E> entityClass) {
		this.entity = entityClass;
		factory = Persistence.createEntityManagerFactory("4JV");
		try {
			transaction = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public E persist(E entity) {
		try {
			transaction.begin();
			this.getEntityManager().persist(entity);
			this.getEntityManager().flush();
			transaction.commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void remove(E entity) {
		try {
			transaction.begin();
			this.getEntityManager().remove(entity);
			this.getEntityManager().flush();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public E update(E entity) {
		try {
			transaction.begin();
			this.getEntityManager().merge(entity);
			this.getEntityManager().flush();
			transaction.commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public E findById(int id) {
		E e = this.getEntityManager().find(this.entity, id);
		return e;
	}
}
