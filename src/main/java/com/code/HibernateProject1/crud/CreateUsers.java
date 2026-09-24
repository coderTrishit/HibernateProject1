package com.code.HibernateProject1.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.Users;
import com.code.HibernateProject1.entity.Users.Role;

public class CreateUsers {
	//create a SessionFactory
	private SessionFactory sessionFactory;
	//create constructor with arg SessionFactory
	public CreateUsers(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		//session object using the SessionFactory Object
		Session session = sessionFactory.getCurrentSession();
		//start the transaction to work with the session object
		session.beginTransaction();
		//create object of orders
		Users users=new Users("Trishit Ghosh", "t@12345", "tg@gmail.com", Role.ADMIN);
		//save the object
		session.persist(users);
		//2nd object
		 users=new Users("Disha Dutta", "dd@12345", "dd@gmail.com", Role.CUSTOMER);
		//save the object
		session.persist(users);
		//3rd object
		users=new Users("Diya Sarkar", "ds@12345", "ds@gmail.com", Role.CUSTOMER);
		//save the object
		session.persist(users);
		//to save into the database we have to call a commit
		session.getTransaction().commit();
		//close the session
		session.close();
		//give a message to user
		System.out.println("Users are created successfully");
	}
}
