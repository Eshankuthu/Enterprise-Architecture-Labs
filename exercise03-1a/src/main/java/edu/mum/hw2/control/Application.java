package edu.mum.hw2.control;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.mum.hw2.model.a.Department;
import edu.mum.hw2.model.a.Employee;

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
			
			// ---- Bidirectional OneToMany Report A -----
			

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

			// ---- Bidirectional OneToMany -----
			Department department = new Department();
			department.setName("Computer");

			Employee emp1 = new Employee();
			emp1.setName("Eshan");
			emp1.setDepartment(department);

			Employee emp2 = new Employee();
			emp2.setName("Prasanna");
			emp2.setDepartment(department);

			List<Employee> employee = new ArrayList();
			employee.add(emp1);
			employee.add(emp2);

			department.setEmployee(employee);

			em.persist(department);
			em.persist(emp1);
			em.persist(emp2);

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
