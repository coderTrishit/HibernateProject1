package com.code.HibernateProject1.crud;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.Orders;
import com.code.HibernateProject1.entity.Users;

public class CreateOrders {
	//create a SessionFactory
	private SessionFactory sessionFactory;
	//create constructor with arg SessionFactory
	public CreateOrders(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		//session object using the SessionFactory Object
		Session session = sessionFactory.getCurrentSession();
		//start the transaction to work with the session object
		session.beginTransaction();
		//user id to get the category
		int usersid=2;
		//get the userid and check it is valid or not
		Users users = session.get(Users.class, usersid);
		if(users == null) {
			System.out.println("Users with id"+usersid+"not found");
			return;
		}
		System.out.println(users.toString());
		//create object of Product
		Orders orders = new Orders(LocalDateTime.parse("2026-09-24T20:15:30"), 500.00 , users);
		//save the object
		session.persist(orders);
		//create 2nd object of Product
		 orders = new Orders(LocalDateTime.parse("2026-09-24T20:25:30"), 300.00 , users);
		//save the object
		session.persist(orders);
		//create 3rd object of Product
		 orders = new Orders(LocalDateTime.parse("2026-09-24T20:35:30"), 800.00 , users);
		//save the object
		session.persist(orders);
		//to save into the database we have to call a commit
		session.getTransaction().commit();
		//close the session
		session.close();
		//give a message to user
		System.out.println("Orders is created successfully");
	}
}
