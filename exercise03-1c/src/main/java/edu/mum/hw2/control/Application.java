package edu.mum.hw2.control;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.mum.hw2.model.Course;
import edu.mum.hw2.model.Student;



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
			
			// ---- Bidirectional ManyToMany c  -----
			
			List<Student> student = new ArrayList<>();
			Student one = new Student();
			one.setFirstName("Eshan");
			one.setLastName("Kuthu");
			
			Student two = new Student();
			two.setFirstName("Susan");
			two.setLastName("Baskota");
			
			student.add(one);
			student.add(two);
			
			List<Course> course = new ArrayList<>();
		
			Course science = new Course();
			science.setCourseNumber(1234);
			science.setName("Modern Science");
			
			
			course.add(science);
			
			one.setCourse(course);
			
	        em.persist(one);
	        em.persist(two);
	        em.persist(science);
			
			


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
