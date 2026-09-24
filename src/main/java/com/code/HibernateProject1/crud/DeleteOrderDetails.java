package com.code.HibernateProject1.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.OrderDetails;


public class DeleteOrderDetails{
	//create a SessionFactory
	private SessionFactory sessionFactory;
	//create constructor with arg SessionFactory
	public DeleteOrderDetails(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		//session object using the SessionFactory Object
		Session session=sessionFactory.getCurrentSession();
		//Start the transaction
		session.beginTransaction();
		//id to want to update
		int deleteid=1;
		//get the objects from the OrderDetails with id deleteid
		OrderDetails orderDetails = session.get(OrderDetails.class, deleteid);
		//check weather the id is present or not
		if(orderDetails == null)
		{
			System.out.println("orderDetails  with id "+deleteid+" not found");
			return;
		}
		//show the current object values
		System.out.println(orderDetails.toString());
		//remove the object
		session.remove(orderDetails);
		//save the transaction
		session.getTransaction().commit();
		//close the session
		session.close(); //detached
		System.out.println("OrderDetails is deleted successfully");
	}
	
}
