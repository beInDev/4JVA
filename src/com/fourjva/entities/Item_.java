package com.fourjva.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-12-17T22:58:06.197+0100")
@StaticMetamodel(Item.class)
public class Item_ {
	public static volatile SingularAttribute<Item, Integer> ItemId;
	public static volatile SingularAttribute<Item, Integer> UserId;
	public static volatile SingularAttribute<Item, String> Title;
	public static volatile SingularAttribute<Item, String> Description;
	public static volatile SingularAttribute<Item, Double> Price;
	public static volatile SingularAttribute<Item, String> Type;
	public static volatile SingularAttribute<Item, String> ImageURL;
	public static volatile SingularAttribute<Item, User> Owner;
}
