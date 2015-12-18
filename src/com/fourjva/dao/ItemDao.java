package com.fourjva.dao;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import com.fourjva.dao.base.JpaDao;
import com.fourjva.entities.Item;
import com.fourjva.entities.Item_;
import com.fourjva.entities.User;

@Stateless
public class ItemDao extends JpaDao<Item> {

	public ItemDao() {
		super(Item.class);
	}
	
	public List<Item> getUserItems(User user){
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Item> cquery = builder.createQuery(Item.class);
		Root<Item> item = cquery.from(Item.class);
		cquery.select(item);
		cquery.where(builder.equal(item.get(Item_.Owner), user));
		TypedQuery<Item> query = getEntityManager().createQuery(cquery);
		List<Item> items = query.getResultList();
		return items;
	}
	
	public List<Item> getAllItems()
	{
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Item> cquery = builder.createQuery(Item.class);
		Root<Item> item = cquery.from(Item.class);
		cquery.select(item);
		TypedQuery<Item> query = getEntityManager().createQuery(cquery);
		List<Item> items = query.getResultList();
		return items;
	}
	
	public List<Item> getLatestItems()
	{
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Item> cquery = builder.createQuery(Item.class);
		Root<Item> item = cquery.from(Item.class);
		cquery.select(item);
		cquery.orderBy(builder.desc(item.get(Item_.CreatedWhen)));
		TypedQuery<Item> query = getEntityManager().createQuery(cquery);
		List<Item> items = query.getResultList();
		return items;
	}
}
