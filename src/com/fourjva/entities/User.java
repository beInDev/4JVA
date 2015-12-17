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
	private int userId;
	private String UserName;
	private String FName;
	private String LName;
	private String Email;
	private int CodePostal;
	private String Password;
	@OneToMany(targetEntity=Item.class)
	private List Items;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}   
	public String getUserName() {
		return this.UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}   
	public String getFName() {
		return this.FName;
	}

	public void setFName(String FName) {
		this.FName = FName;
	}   
	public String getLName() {
		return this.LName;
	}

	public void setLName(String LName) {
		this.LName = LName;
	}   
	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}   
	public int getCodePostal() {
		return this.CodePostal;
	}

	public void setCodePostal(int CodePostal) {
		this.CodePostal = CodePostal;
	}   
	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}
   
}
