package com.fourjva.rest;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import com.fourjva.dao.ItemDao;
import com.fourjva.entities.Item;

/**
 * Items WebService to manage items from the API
 */
@Path("items")
public class Items {

	@GET
	@Path("create")
	public String createItem() {
		Item item = new Item();
		item.setTitle("roflmao");
		ItemDao dao = new ItemDao();
		dao.persist(item);
		return "lol internet";
	}
	
	/**
	 * Retrieves the 10 last added items
	 * @return List
	 * @see Item
	 */
	@GET
	@Path("last")
	@Produces("application/json")
	public List<Item> getLastItems() {
		ItemDao dao = new ItemDao();
		List<Item> listItems = dao.getLatestItems();
		
		//listItems.forEach();
//		Collections.sort(listItems, c);
				
		if (listItems.size() < 10) {
			return listItems;
		}
		return listItems.subList(0, 10); // if listItems > 10 results => sublist
	}
	
	/**
	 * Search for items corresponding to the specified filters
	 * @return List
	 * @see Item
	 */
	@GET
	@Path("search")
	public String searchItems(@QueryParam("itemId") String itemId, @QueryParam("quantity") int qty) {
		
		return "created " + qty + " item #" + itemId;
	}
	@GET
	@Path("json")
	@Produces("application/json")
	public Item getJson() {
		return new Item(1, "lol");
	}
	
}
