package com.fourjva.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-12-15T12:49:07.593+0100")
@StaticMetamodel(users.class)
public class users_ {
	public static volatile SingularAttribute<users, Integer> userId;
	public static volatile SingularAttribute<users, String> UserName;
	public static volatile SingularAttribute<users, String> FName;
	public static volatile SingularAttribute<users, String> LName;
	public static volatile SingularAttribute<users, String> Email;
	public static volatile SingularAttribute<users, Integer> CodePostal;
}
