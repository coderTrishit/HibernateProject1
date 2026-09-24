package com.code.HibernateProject1.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.Product;


public class DeleteProduct{
	//create a SessionFactory
	private SessionFactory sessionFactory;
	//create constructor with arg SessionFactory
	public DeleteProduct(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		//session object using the SessionFactory Object
		Session session=sessionFactory.getCurrentSession();
		//Start the transaction
		session.beginTransaction();
		//id to want to update
		int deleteid=3;
		//get the objects from the category with id deleteid
		Product product = session.get(Product.class, deleteid);
		//check weather the id is present or not
		if(product == null)
		{
			System.out.println("product  with id "+deleteid+" not found");
			return;
		}
		//show the current object values
		System.out.println(product.toString());
		//remove the object
		session.remove(product);
		//save the transaction
		session.getTransaction().commit();
		//close the session
		session.close(); //detached
		System.out.println("Product is deleted successfully");
	}
	
}
