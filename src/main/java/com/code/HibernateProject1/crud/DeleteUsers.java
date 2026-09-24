package com.code.HibernateProject1.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.code.HibernateProject1.entity.Users;


public class DeleteUsers{
	//create a SessionFactory
	private SessionFactory sessionFactory;
	//create constructor with arg SessionFactory
	public DeleteUsers(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		//session object using the SessionFactory Object
		Session session=sessionFactory.getCurrentSession();
		//Start the transaction
		session.beginTransaction();
		//id to want to delete
		int deleteid=3;
		//get the objects from the users with id deleteid
		Users users = session.get(Users.class, deleteid);
		//check weather the id is present or not
		if(users== null)
		{
			System.out.println("Users  with id "+deleteid+" not found");
			return;
		}
		//show the current object values
		System.out.println(users.toString());
		//remove object from table 
		session.remove(users);
		//save the transaction
		session.getTransaction().commit();
		//close the session
		session.close(); //detached
		System.out.println("User is deleted successfully");
	}
	
}
