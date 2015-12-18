package com.fourjva.dao;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.fourjva.dao.base.JpaDao;
import com.fourjva.entities.Item;
import com.fourjva.entities.Item_;
import com.fourjva.entities.User;

/**
 * DAO handling all Item access requests
 */
@Stateless
public class ItemDao extends JpaDao<Item> { 

	public ItemDao() {
		super(Item.class);
	}
	
	/**
	 * Get Items belonging to a specific User
	 * @param user The User to retrieve the items of
	 * @return List
	 * @see User
	 * @see Item
	 */
	public List<Item> getUserItems(User user){ // 
		EntityManager em = getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Item> cquery = builder.createQuery(Item.class);
		Root<Item> item = cquery.from(Item.class);
		cquery.select(item);
		cquery.where(builder.equal(item.get(Item_.Owner), user));
		TypedQuery<Item> query = em.createQuery(cquery);
		List<Item> items = query.getResultList();
		return items;
	}
	/**
	 * Get all Items
	 * @return List
	 */
	public List<Item> getAllItems()
	{
		EntityManager em = getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Item> cquery = builder.createQuery(Item.class);
		Root<Item> item = cquery.from(Item.class);
		cquery.select(item);
		TypedQuery<Item> query = em.createQuery(cquery);
		List<Item> items = query.getResultList();
		return items;
	}
	/**
	 * Get all items ordered by their creation date in a descending order (newest to oldest)
	 * @return List
	 */
	public List<Item> getLatestItems()
	{
		EntityManager em = getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Item> cquery = builder.createQuery(Item.class);
		Root<Item> item = cquery.from(Item.class);
		cquery.select(item);
		cquery.orderBy(builder.desc(item.get(Item_.CreatedWhen)));
		TypedQuery<Item> query = em.createQuery(cquery);
		List<Item> items = query.getResultList();
		return items;
	}
	/**
	 * Gets the last added item
	 * @return Item
	 */
	public Item getLastItem()
	{
		EntityManager em = getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Item> cquery = builder.createQuery(Item.class);
		Root<Item> item = cquery.from(Item.class);
		cquery.select(item);
		cquery.orderBy(builder.desc(item.get(Item_.CreatedWhen)));
		TypedQuery<Item> query = em.createQuery(cquery);
		List<Item> items = query.getResultList();
		if(items.size() > 0)
			return items.get(0);
		else
			return null;
	}

	/**
	 * 
	 * @return
	 */
	public Long getTotalItemCount() {
		EntityManager em = getEntityManager();
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Long> cquery = builder.createQuery(Long.class);
		cquery.select(builder.count(cquery.from(Item.class)));
		return em.createQuery(cquery).getSingleResult();
	}
}
