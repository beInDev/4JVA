package com.fourjva.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.fourjva.dao.base.JpaDao;
import com.fourjva.entities.Item;
import com.fourjva.entities.User;
import com.fourjva.entities.User_;

/**
 * DAO handling all User access requests
 */
@Stateless
public class UserDao extends JpaDao<User> {
	
	public UserDao() {
		super(User.class);
	}
	
	/**
	 * Retrieve the owner of an Item
	 * @param item The Item to retrieve the owner of
	 * @return User
	 * @see User
	 * @see Item
	 */
	public User getOwner(Item item)
	{
		EntityManager em = getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<User> cquery = builder.createQuery(User.class);
		Root<User> user = cquery.from(User.class);
		cquery.select(user);
		cquery.where(builder.equal(user.get(User_.userId), item.getOwner().getUserId()));
		TypedQuery<User> query = em.createQuery(cquery);
		User u = query.getResultList().get(0);
		return u;
		
	}
	/**
	 * Returns the total number of registered users.
	 * @return int
	 */
	public Long getRegisteredUsersNumber() {
		EntityManager em = getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Long> cquery = builder.createQuery(Long.class);
		cquery.select(builder.count(cquery.from(User.class)));
		return em.createQuery(cquery).getSingleResult();
	}
	
	/**
	 * Gets a user by its username
	 * @return int
	 */
	public User getUserByUsername(String username) {
		EntityManager em = getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<User> cquery = builder.createQuery(User.class);
		Root<User> user = cquery.from(User.class);
		cquery.select(user);
		cquery.where(builder.equal(user.get(User_.UserName), username));
		TypedQuery<User> query = em.createQuery(cquery);
		User u = query.getResultList().get(0);
		return u;
	}
}
