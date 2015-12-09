package com.fourjva.entities;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Dummy {
	
	int Id;
	@Id
	public int getId() { return Id; }

    public void setId(int id) { this.Id = id; }

	public String Name;
}