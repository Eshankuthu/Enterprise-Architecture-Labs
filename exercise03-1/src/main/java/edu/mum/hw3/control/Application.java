package edu.mum.hw3.control;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.mum.hw3.domain.f.Employee;
import edu.mum.hw3.domain.f.Office;

public class Application {
	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("cs544"); // <persistence-unit
																	// name="cs544">
																	// in persistance.xml
																	
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			// TODO your code
			//question no a
			/*List<Employee> employeeList = new ArrayList<Employee>();
			
			Department department = new Department();
			department.setName("Science Depart");
			
			Employee employee1 = new Employee();
			employee1.setName("saskar");
			employee1.setDepartment(department);
			
			Employee employee2 = new Employee();
			employee2.setName("sangi");
			employee2.setDepartment(department);
			
			employeeList.add(employee1);
			employeeList.add(employee2);
			
			department.setEmployeeList(employeeList);
			
			em.persist(department);*/
			
			//question no b
			/*Publisher publisher = new Publisher();
			publisher.setName("Bhudi puran publication");
			
			Book book1 = new Book();
			Book book2 = new Book();
			
			book1.setIsbn(123);
			book1.setAuthor("Kuthu");
			book1.setTitle("kuthu book");
			book1.setPublisher(publisher);
			
			book2.setIsbn(124);
			book2.setAuthor("robin");
			book2.setTitle("robin book");
			//book2.setPublisher(publisher);
	
			
			em.persist(book1);
			em.persist(book2);
			em.persist(publisher);*/
			
			/*Student student = new Student();
			student.setSid(10);
			student.setFirstName("susan");
			student.setLastName("baskota");
			
			Student student1 = new Student();
			student1.setSid(11);
			student1.setFirstName("sanskar");
			student1.setLastName("baskota");
			
			Course course = new Course();
			course.setCourseNumber("cs435");
			course.setName("algorithm");
			course.setStudentList(Arrays.asList(student,student1));
			
			Course course1 = new Course();
			course1.setCourseNumber("cs542");
			course1.setName("EA");
			course1.setStudentList(Arrays.asList(student,student1));
			
			student.setCourseList(Arrays.asList(course,course1));
			student1.setCourseList(Arrays.asList(course, course1));
			
			em.persist(student);
			em.persist(student1);
			em.persist(course);
			em.persist(course1);*/
			
		/*	Book book = new Book();
			book.setIsbn(5234);
			book.setAuthor("jk rowling");
			book.setTitle("harry potter");
			
			Reservation reservation1 =  new Reservation();
			reservation1.setDate(Date.valueOf("2016-08-07"));
			reservation1.setBook(book);
			Reservation reservation2 =  new Reservation();
			reservation2.setDate(Date.valueOf("2017-08-07"));
			reservation2.setBook(book);
			Reservation reservation3 =  new Reservation();
			reservation3.setDate(Date.valueOf("2018-08-07"));
			reservation3.setBook(book);
			
			Customer customer = new Customer();
			customer.setName("susan");
			customer.setReservationList(Arrays.asList(reservation1,reservation2,reservation3));
			
			em.persist(customer);
			em.persist(book);*/
			
			Employee employee1 = new Employee();
			employee1.setName("tanka");
			
			Employee employee2 = new Employee();
			employee2.setName("binda");
			
			Office office = new Office();
			office.setBuilding("drier");
			office.setRoomNo(32);
			office.setEmployeeList(Arrays.asList(employee1,employee2));
			
			employee1.setOffice(office);
			employee2.setOffice(office);
			
			//em.persist(employee1);
			//em.persist(employee2);
			em.persist(office);
			
			tx.commit();
			// output method

		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive()))
				tx.rollback();
			System.out.println("hello");
		} finally {
			if ((em != null) && (em.isOpen()))
				em.close();
		}
		if (emf.isOpen()) {
			emf.close();
		}
	}
}
