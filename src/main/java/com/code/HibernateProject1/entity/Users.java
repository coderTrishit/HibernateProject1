package com.code.HibernateProject1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="username",length=50,nullable=false,unique = true)
	private String username;
	@Column(name="password",nullable = false)
	private String password;
	@Column(name="email",length=50,nullable=false,unique = true)
	private String email;

	public enum Role {
	    ADMIN,
	    CUSTOMER
	}
	@Enumerated(EnumType.STRING)
	@Column(name="Role",length=10,nullable=false)
	private Role role;
	//Default Constructor
	public Users()
	{
		this.id=0;
		this.username=null;
		this.password=null;
		this.email=null;
	}
    //Parameterized Constructor
	public Users(String username, String password, String email, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	 //Getter and setter //Getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	 // To String
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", role="
				+ role + "]";
	}
	
}
