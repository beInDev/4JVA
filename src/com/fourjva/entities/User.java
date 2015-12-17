package com.fourjva.entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: users
 *
 */
@Entity
public class User implements Serializable {

	   
	@Id
	@GeneratedValue
	public int userId;
	public String UserName;
	public String FName;
	public String LName;
	public String Email;
	public int CodePostal;
	public String Password;
	@OneToMany(targetEntity=Item.class)
	public List<Item> Items;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
   
}
