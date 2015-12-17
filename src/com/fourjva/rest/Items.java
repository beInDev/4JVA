package com.fourjva.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.fourjva.dao.ItemDao;
import com.fourjva.entities.Item;


@Path("items")
public class Items {

	@GET
	@Path("create")
	public String getLastItems() {
		Item item = new Item();
		item.Title = "roflmao";
		ItemDao dao = new ItemDao();
		dao.persist(item);
		return "lol internet";
	}
		
	@GET
	@Path("id/{identifier}") // can add a regEx // QueryParam
	public String getById(@PathParam ("identifier") String myId) {
		return myId;
	}
	
	@GET
	@Path("json")
	@Produces("application/json")
	public Item getJson() {
		return new Item(1, "lol");
	}
	
}
