package com.code.HibernateProject1.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.Users;

public class UpdateUsers {
	//create a SessionFactory
	private SessionFactory sessionFactory;
	//create constructor with arg SessionFactory
	public UpdateUsers(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		//session object using the SessionFactory Object
		Session session=sessionFactory.getCurrentSession();
		//Start the transaction
		session.beginTransaction();
		//id to want to update
		int updateid=3;
		//get the objects from the category with id updateid
		Users users = session.get(Users.class, updateid);
		//check weather the id is present or not
		if(users == null)
		{
			System.out.println("Users  with id "+updateid+" not found");
			return;
		}
		//show the current object values
		System.out.println(users.toString());
		//set the new value
		users.setEmail("dsk@gmail.com");
		//update the object
		session.merge(users);
		//save the transaction
		session.getTransaction().commit();
		//close the session
		session.close(); //detached
		System.out.println("Users is updated successfully");
	}
	
}
