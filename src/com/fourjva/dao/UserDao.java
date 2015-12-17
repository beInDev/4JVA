package com.fourjva.dao;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.fourjva.dao.base.JpaDao;
import com.fourjva.entities.Item;
import com.fourjva.entities.User;

@Stateless
public class UserDao extends JpaDao<User> {
	
	public UserDao() {
		super(User.class);
	}
	
	public User getOwner(Item item)
	{
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<User> cquery = builder.createQuery(User.class);
		Root<User> user = cquery.from(User.class);
		cquery.select(user);
		cquery.where(builder.equal(user.get("Id"), item.ItemId));
		TypedQuery<User> query = getEntityManager().createQuery(cquery);
		User u = query.getResultList().get(0);
		return u;
		
	}
}
