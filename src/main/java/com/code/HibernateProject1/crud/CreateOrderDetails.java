package com.code.HibernateProject1.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.code.HibernateProject1.entity.OrderDetails;
import com.code.HibernateProject1.entity.Orders;
import com.code.HibernateProject1.entity.Product;


public class CreateOrderDetails {
	//create a SessionFactory
	private SessionFactory sessionFactory;
	//create constructor with arg SessionFactory
	public CreateOrderDetails(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		//session object using the SessionFactory Object
		Session session = sessionFactory.getCurrentSession();
		//start the transaction to work with the session object
		session.beginTransaction();
		//orders id to get the orders
		int ordersid=2;
		//product id to get the product
		int productid=2;
		//get the ordersid and check it is valid or not
		Orders orders = session.get(Orders.class, ordersid);
		if(orders == null) {
			System.out.println("Users with id"+ordersid+"not found");
			return;
		}
		System.out.println(orders.toString());
		//get the productid and check it is valid or not
		Product product = session.get(Product.class, productid);
		if(product == null) {
				System.out.println("Users with id"+productid+"not found");
				return;
		}
		System.out.println(product.toString());
		//Create the object of OrderDetails
		OrderDetails orderDetails = new OrderDetails(1, 300.00, orders, product);
		session.persist(orderDetails);
		//to save into the database we have to call a commit
		session.getTransaction().commit();
		//close the session
		session.close();
		//give a message to user
		System.out.println("OrderDetails is created successfully");
	}
}
