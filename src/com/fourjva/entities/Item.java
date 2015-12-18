package com.fourjva.entities;

import java.io.Serializable;
import java.lang.Double;
import java.lang.String;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

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
	private int ItemId;
	private String Title;
	private String Description;
	private Double Price;
	private String Type;
	private String ImageURL;
	@OneToOne(targetEntity=User.class)
	private User Owner;
	@Basic(optional = false)
	@Column(name = "LastTouched", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date CreatedWhen;
	private static final long serialVersionUID = 1L;

	
	
	public Item() {
		super();
		//this.CreatedWhen = new Timestamp(Calendar.getInstance().getTime().getTime()); 
	}   

	public Item(int id, String title) {
		super();
		this.ItemId = id;
		this.Title = title;
		//this.CreatedWhen = new Timestamp(Calendar.getInstance().getTime().getTime()); 
	}
	
	public int getItemId() {
		return ItemId;
	}

	public Date getCreatedWhen() {
		return CreatedWhen;
	}

	public void setCreatedWhen(Date createdWhen) {
		this.CreatedWhen = createdWhen;
	}

	public void setItemId(int itemId) {
		ItemId = itemId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getImageURL() {
		return ImageURL;
	}

	public void setImageURL(String imageURL) {
		ImageURL = imageURL;
	}

	public User getOwner() {
		return Owner;
	}

	public void setOwner(User owner) {
		Owner = owner;
	}


   
}
