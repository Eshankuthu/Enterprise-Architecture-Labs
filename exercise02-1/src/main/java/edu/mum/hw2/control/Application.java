package edu.mum.hw2.control;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.mum.hw2.domain.Actor;
import edu.mum.hw2.domain.Movie;

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
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			//code for report creation
			Movie movie = em.find(Movie.class,1);
			
			System.out.println("<-------Movie Report-------->");
			System.out.println("Movie Name: "+movie.getName());
			System.out.println("Movie Cover: "+movie.getCover());
			System.out.println("Movie Rating: "+movie.getRating());
			
			System.out.println("<--------Actors---------->");
			for(Actor actor: movie.getActor()){	
				System.out.println("   -"+actor.getName());
			}
			tx.commit();
		} catch (Throwable e) {
			if ((tx != null) && (tx.isActive())) tx.rollback();
			System.out.println("hello");
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}	
	}

	private static void addMovies() {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();

			// TODO your code
			Movie movie1 = new Movie();
			Set<String> category = new HashSet<>();

			List<String> comment = new ArrayList<>();

			category.add("comedy");
			category.add("action");
			category.add("thriller");

			comment.add("very nice");
			comment.add("vary bad movie");
			comment.add("wow! what a great movie");

			Actor actor1 = new Actor();
			actor1.setName("saskar");
			actor1.setCharacter("action hero");
			actor1.setRating(8);

			Actor actor2 = new Actor();
			actor2.setName("sushan");
			actor2.setCharacter("action hero");
			actor2.setRating(9);

			List<Actor> actorList = new ArrayList<>();
			actorList.add(actor1);
			actorList.add(actor2);

			movie1.setActor(actorList);
			movie1.setCategory(category);
			movie1.setComment(comment);
			movie1.setName("Game Of Thrones");
			movie1.setRating(9);
			movie1.setCover("GOT Season 7");

			em.persist(movie1);

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
