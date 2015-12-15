package com.fourjva.entities;

import java.io.Serializable;
import java.lang.Double;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: item
 *
 */
@Entity

public class item implements Serializable {

	   
	@Id
	private int ItemId;
	private int UserId;
	private String Title;
	private String Description;
	private Double Price;
	private String Type;
	private String ImageURL;
	private static final long serialVersionUID = 1L;

	public item() {
		super();
	}   
	public int getItemId() {
		return this.ItemId;
	}

	public void setItemId(int ItemId) {
		this.ItemId = ItemId;
	}   
	public int getUserId() {
		return this.UserId;
	}

	public void setUserId(int UserId) {
		this.UserId = UserId;
	}   
	public String getTitle() {
		return this.Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}   
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}   
	public Double getPrice() {
		return this.Price;
	}

	public void setPrice(Double Price) {
		this.Price = Price;
	}   
	public String getType() {
		return this.Type;
	}

	public void setType(String Type) {
		this.Type = Type;
	}   
	public String getImageURL() {
		return this.ImageURL;
	}

	public void setImageURL(String ImageURL) {
		this.ImageURL = ImageURL;
	}
   
}
