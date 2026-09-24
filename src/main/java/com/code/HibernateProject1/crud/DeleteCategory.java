package com.code.HibernateProject1.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.Category;

public class DeleteCategory {
	//create a SessionFactory
	private SessionFactory sessionFactory;
	//create constructor with arg SessionFactory
	public DeleteCategory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		//session object using the SessionFactory Object
		Session session=sessionFactory.getCurrentSession();
		//Start the transaction
		session.beginTransaction();
		//id to want to delete
		int deleteid=3;
		//get the objects from the category with id deleteid
		Category category = session.get(Category.class, deleteid);
		//check weather the id is present or not
		if(category == null)
		{
			System.out.println("Category  with id "+deleteid+" not found");
			return;
		}
		//show the current object values
		System.out.println(category.toString());
		//remove object from table 
		session.remove(category);
		//save the transaction
		session.getTransaction().commit();
		//close the session
		session.close(); //detached
		System.out.println("Category is deleted successfully");
	}
	
}
