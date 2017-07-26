package edu.mum.hw2.control;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.mum.hw2.domain.Order;
import edu.mum.hw2.domain.OrderLine;
import edu.mum.hw2.domain.Product;

public class Application {

	private static EntityManagerFactory emf;
	 
	static { 
		try { 
			emf = Persistence.createEntityManagerFactory("cs544");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		} 
	} 
 
	public static void main(String[] args) {
 
		addMovies(); 
		printMoviesReport(); 
		emf.close();
	} 
 
	private static void printMoviesReport() { 
		// TODO Auto-generated method stub 
	/*	EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try { 
			tx.begin();
			//code for report creation 
			
			tx.commit();
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive())) tx.rollback();
			System.out.println("hello");
		} finally { 
			if ((em != null) && (em.isOpen())) em.close();
		}*/	 
	} 
 
	private static void addMovies() { 
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try { 
			tx.begin();
 
			// TODO your code 
			Product product = new Product();
			product.setName("mobile");
			product.setDescription("very good mobile");
			OrderLine orderline = new OrderLine();
			orderline.setProduct(product);
			orderline.setQuantity(4);
 
			List<OrderLine> orderlist = new ArrayList<>();
			Order order = new Order();
			order.setDate(Date.valueOf("2017-05-09"));
			order.setOrderLine(orderlist);
			
			em.persist(order);
			em.persist(orderline);
 
			tx.commit();
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive()))
				tx.rollback();
			System.out.println("hello");
		} finally { 
			if ((em != null) && (em.isOpen()))
				em.close();
		} 
	} 
}
