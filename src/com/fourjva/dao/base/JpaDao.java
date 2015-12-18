package com.fourjva.dao.base;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import javax.ejb.Stateless;
import javax.naming.InitialContext;

/**
 * Base class for managing persisted entities and creating DAOs
 * @param <E> Entity class on which the DAO will work
 */
@Stateless
public abstract class JpaDao<E> { 
	protected Class<E> entity;
	@PersistenceUnit(unitName="4JV")
	protected EntityManagerFactory factory;
	protected UserTransaction transaction;
	
	/**
	 * Creates and return an EntityManager instance for the current PersistenceUnit
	 * @return EntityManager
	 */
	protected EntityManager getEntityManager(){
		return factory.createEntityManager();
	}
	
	public JpaDao(Class<E> entityClass) {
		this.entity = entityClass;
		try {
			transaction = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(factory != null)
			return;
		else
		factory = Persistence.createEntityManagerFactory("4JV");
	}

	/**
	 * Persists an Entity
	 * @param entity The Entity to persist
	 * @return Entity
	 */
	public E persist(E entity) {
		try {
			EntityManager em = this.getEntityManager();
			transaction.begin();
			em.persist(entity);
			em.joinTransaction();
			em.flush();
			transaction.commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Removes an Entity from persistence
	 * @param entity The Entity to remove
	 */
	public void remove(E entity) {
		try {
			EntityManager em = this.getEntityManager();
			transaction.begin();
			em.remove(entity);
			em.joinTransaction();
			em.flush();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * Updates an entity
	 * @param entity The entity to update
	 */
	public E update(E entity) {
		try {
			EntityManager em = this.getEntityManager();
			transaction.begin();
			em.merge(entity);
			em.joinTransaction();
			em.flush();
			transaction.commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	/**
	 * Retrieve an entity with the specified ID
	 * @param id The Entity's ID
	 * @return Entity
	 */
	public E findById(Long id) {
		E e = this.getEntityManager().find(this.entity, id);
		return e;
	}
}
