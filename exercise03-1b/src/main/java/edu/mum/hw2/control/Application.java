package edu.mum.hw2.control;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.mum.hw2.model.Book;
import edu.mum.hw2.model.Publisher;


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

		add();
		printReport();
		emf.close();
	}

	private static void printReport() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			// ---- Optional Unidirectional ManyToOne b  -----
			
		 Book book = new Book();
		 book.setIsbn(155);
		 book.setAuthor("Eshan");
		 book.setTitle("The Power of Now");
		 
		 Book book2 = new Book();
		 book2.setIsbn(288);
		 book2.setAuthor("Susan");
		 book2.setTitle("The Monk who sold his ferrari");
		 
		 Publisher publisher = new Publisher();
		 publisher.setName("Media House");
		
		 book.setPublisher(publisher);
		 
		 em.persist(book);
		 em.persist(book2);
		 em.persist(publisher);
		 
		 System.out.println("\n Book Report"
		 					+ "\n Book Title "+ book.getAuthor());
			

			tx.commit();

		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive()))
				tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen()))
				em.close();
		}
	}

	private static void add() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			// ----  Optional Unidirectional ManyToOne b -----
		

			tx.commit();

		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive()))
				tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen()))
				em.close();
		}
	}

}
