package com.code.HibernateProject1.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.Category;

public class UpdateCategory {
	//create a SessionFactory
	private SessionFactory sessionFactory;
	//create constructor with arg SessionFactory
	public UpdateCategory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		//session object using the SessionFactory Object
		Session session=sessionFactory.getCurrentSession();
		//Start the transaction
		session.beginTransaction();
		//id to want to update
		int updateid=1;
		//get the objects from the category with id updateid
		Category category = session.get(Category.class, updateid);
		//check weather the id is present or not
		if(category == null)
		{
			System.out.println("Category  with id "+updateid+" not found");
			return;
		}
		//show the current object values
		System.out.println(category.toString());
		//set the new value
		category.setDescription("All electronic products");
		//update the object
		session.merge(category);
		//save the transaction
		session.getTransaction().commit();
		//close the session
		session.close(); //detached
		System.out.println("Category is updated successfully");
	}
	
}
