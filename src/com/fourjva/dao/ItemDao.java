package com.fourjva.dao;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.fourjva.dao.base.Dao;
import com.fourjva.dao.base.JpaDao;
import com.fourjva.entities.Item;
import com.fourjva.entities.User;

@Stateless
public class ItemDao extends JpaDao<Item,Integer> {

	public List getUserItems(User user){
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Item> cquery = builder.createQuery(Item.class);
		Root<Item> item = cquery.from(Item.class);
		cquery.select(item);
		cquery.where(builder.equal(item.get("Owner"), user));
		TypedQuery<Item> query = manager.createQuery(cquery);
		List items = query.getResultList();
		return items;
	}
	
	public List getAllItems()
	{
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Item> cquery = builder.createQuery(Item.class);
		Root<Item> item = cquery.from(Item.class);
		cquery.select(item);
		TypedQuery<Item> query = manager.createQuery(cquery);
		List items = query.getResultList();
		return items;
	}
}
