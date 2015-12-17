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
public class UserDao extends JpaDao {
	
	public UserDao() {
		super(User.class);
	}
	
	public User getOwner(Item item)
	{
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<User> cquery = builder.createQuery(User.class);
		Root<User> user = cquery.from(User.class);
		cquery.select(user);
		cquery.where(builder.equal(user.get("Id"), item.getUserId()));
		TypedQuery<User> query = manager.createQuery(cquery);
		User u = query.getResultList().get(0);
		return u;
		
	}
}
