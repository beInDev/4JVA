package com.fourjva.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-12-17T01:48:22.109+0100")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, Integer> userId;
	public static volatile SingularAttribute<User, String> UserName;
	public static volatile SingularAttribute<User, String> FName;
	public static volatile SingularAttribute<User, String> LName;
	public static volatile SingularAttribute<User, String> Email;
	public static volatile SingularAttribute<User, Integer> CodePostal;
	public static volatile SingularAttribute<User, String> Password;
	public static volatile ListAttribute<User, Item> Items;
}
