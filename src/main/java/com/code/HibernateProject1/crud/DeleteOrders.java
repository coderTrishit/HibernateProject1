package com.code.HibernateProject1.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.Orders;



public class DeleteOrders{
	//create a SessionFactory
	private SessionFactory sessionFactory;
	//create constructor with arg SessionFactory
	public DeleteOrders(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		//session object using the SessionFactory Object
		Session session=sessionFactory.getCurrentSession();
		//Start the transaction
		session.beginTransaction();
		//id to want to update
		int deleteid=3;
		//get the objects from the Orders with id deleteid
		Orders orders = session.get(Orders.class, deleteid);
		//check weather the id is present or not
		if(orders == null)
		{
			System.out.println("order  with id "+deleteid+" not found");
			return;
		}
		//show the current object values
		System.out.println(orders.toString());
		//remove the object
		session.remove(orders);
		//save the transaction
		session.getTransaction().commit();
		//close the session
		session.close(); //detached
		System.out.println("Orders is deleted successfully");
	}
	
}
