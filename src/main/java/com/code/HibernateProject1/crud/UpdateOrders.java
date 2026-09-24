package com.code.HibernateProject1.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.Orders;


public class UpdateOrders{
	//create a SessionFactory
	private SessionFactory sessionFactory;
	//create constructor with arg SessionFactory
	public UpdateOrders(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		//session object using the SessionFactory Object
		Session session=sessionFactory.getCurrentSession();
		//Start the transaction
		session.beginTransaction();
		//id to want to update
		int updateid=3;
		//get the objects from the Orders with id updateid
		Orders orders = session.get(Orders.class, updateid);
		//check weather the id is present or not
		if(orders == null)
		{
			System.out.println("product  with id "+updateid+" not found");
			return;
		}
		//show the current object values
		System.out.println(orders.toString());
		//set the new value
		orders.setTotalAmount(1100.00);
		//update the object
		session.merge(orders);
		//save the transaction
		session.getTransaction().commit();
		//close the session
		session.close(); //detached
		System.out.println("Order is updated successfully");
	}
	
}
