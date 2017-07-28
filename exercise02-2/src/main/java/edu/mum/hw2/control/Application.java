package edu.mum.hw2.control;

import java.time.LocalDate;
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

		addProduct();
		printProductReport();
		emf.close();
	}

	private static void printProductReport() {
		// TODO Auto-generated method stub
		
      
		

	}

	private static void addProduct() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			

			
			Product product1 = new Product();
			product1.setName("Noodles");
			product1.setDescription("Noodles by Wai Wai");
			
			OrderLine orderline1 = new OrderLine();
			orderline1.setQuantity(10);
			orderline1.setProduct(product1);
			
			List<OrderLine> orderList = new ArrayList();
			orderList.add(orderline1);
				
					
			Order order1 = new Order();
			order1.setDate(LocalDate.now());
			order1.setOrderLine(orderList);
	       
			em.persist(order1);

			tx.commit();
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
	}

}
