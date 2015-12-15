package com.fourjva.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-12-15T13:38:49.922+0100")
@StaticMetamodel(item.class)
public class item_ {
	public static volatile SingularAttribute<item, Integer> ItemId;
	public static volatile SingularAttribute<item, Integer> UserId;
	public static volatile SingularAttribute<item, String> Title;
	public static volatile SingularAttribute<item, String> Description;
	public static volatile SingularAttribute<item, Double> Price;
	public static volatile SingularAttribute<item, String> Type;
	public static volatile SingularAttribute<item, String> ImageURL;
}
