package com.code.HibernateProject1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name",length=50,nullable = false, unique = true)
	private String name;
	@Column(name = "description",length=100,nullable = false)
	private String description;
	//default constructor
	public Category()
	{
		this.id=0;
		this.name=null;
		this.description=null;
	}
     //Parameterized Constructor
	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
    //Getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    // To String 
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
}
