package com.fourjva.entities;

import java.io.Serializable;
import java.lang.Double;
import java.lang.String;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


/**
 * Entity implementation class for Entity: item
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement

@Entity
public class Item implements Serializable {
	@Id
	@GeneratedValue
	public int ItemId;
	public int UserId;
	public String Title;
	public String Description;
	public Double Price;
	public String Type;
	public String ImageURL;
	@OneToOne(targetEntity=User.class)
	public User Owner;
	private static final long serialVersionUID = 1L;

	public Item() {
		super();
		this.ItemId = 123;
		UserId = 012;
		Title = "Kappa";
		Description = "xD";
		Price = 22.0;
		Type = "WOOH";
		ImageURL = "xDDDD";
		Owner = null;
	}   

	public Item(int id, String title) {
		super();
		this.ItemId = id;
		this.Title = title;
	}
   
}
