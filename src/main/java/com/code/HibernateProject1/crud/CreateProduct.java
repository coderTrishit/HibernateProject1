package com.code.HibernateProject1.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.Category;
import com.code.HibernateProject1.entity.Product;

public class CreateProduct {
	//create a SessionFactory
	private SessionFactory sessionFactory;
	//create constructor with arg SessionFactory
	public CreateProduct(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		//session object using the SessionFactory Object
		Session session = sessionFactory.getCurrentSession();
		//start the transaction to work with the session object
		session.beginTransaction();
		//category id to get the category
		int categoryid=2;
		//get the categoryid and check it is valid or not
		Category category = session.get(Category.class, categoryid);
		if(category == null) {
			System.out.println("Category with id"+categoryid+"not found");
			return;
		}
		System.out.println(category.toString());
		//create object of Product
		Product product = new Product("Foundation", 500.00, 5, category);
		//save the object
		session.persist(product);
		// 2nd object
		product = new Product("Lipstick", 300.00, 10, category);
		//save the object
		session.persist(product);
		// 3nd object
		product = new Product("Primer", 400.00, 7, category);
		//save the object
		session.persist(product);
		//to save into the database we have to call a commit
		session.getTransaction().commit();
		//close the session
		session.close();
		//give a message to user
		System.out.println("Product is created successfully");
	}
}
