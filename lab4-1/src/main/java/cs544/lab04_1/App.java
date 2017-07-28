package cs544.lab04_1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;

import cs544.lab04_1.model.Airline;
import cs544.lab04_1.model.Airplane;
import cs544.lab04_1.model.Airport;
import cs544.lab04_1.model.Flight;

public class App {
	private static Logger logger = Logger.getLogger(App.class);;

	private static final EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("lab4");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {
		EntityManager em = null;
		EntityTransaction tx = null;

		// fill the database
		fillDataBase();

		// Flights leaving USA capacity > 500
		try {
			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();

			/*logger.trace("List all the flights:");
			List<Flight> flights = em.createQuery("from Flight").getResultList();
			logger.trace(String.format("%-9s%-31s%-31s", "Flight:", "Departs:",
					"Arrives:"));
			for (Flight flight : flights) {
				logger.trace(String.format(
						"%-7s  %-12s %7s %8s  %-12s %7s %8s",
						flight.getFlightnr(), flight.getOrigin().getCity(),
						flight.getDepartureDate(), flight.getDepartureTime(),
						flight.getDestination().getCity(),
						flight.getArrivalDate(), flight.getArrivalTime()));
			}*/
			
			logger.trace("List all the flights Leaving the USA with capacity > 500:");
			List<Flight> flights = em.createQuery("Select f from Flight f join f.origin f1 join f.airplane f2 where f1.country='USA' and f2.capacity > 500").getResultList();
			
			System.out.println("<----------------List all the flights Leaving the USA with capacity > 500------------------>");
			logger.trace(String.format("%-9s%-31s%-31s", "Flight:", "Departs:",
					"Arrives:"));
			for (Flight flight : flights) {
				logger.trace(String.format(
						"%-7s  %-12s %7s %8s  %-12s %7s %8s",
						flight.getId(),
						flight.getFlightnr(), flight.getOrigin().getCity(),
						flight.getDepartureDate(), flight.getDepartureTime(),
						flight.getDestination().getCity(),
						flight.getArrivalDate(), flight.getArrivalTime()));
			}
			
			logger.trace("List all the airlines that use A380 airplanes");
			List<Airline> airlines = em.createQuery("Select a from Airline a join a.flights a1 join a1.airplane a2 where a2.model='A380'").getResultList();
			//logger.trace(String.format("%-9s%-31s%-31s", "AirlineId:", "AirlineName:"));
			System.out.println("<----------------List all the airlines that use A380 airplanes------------------>");
			for (Airline airline : airlines) {
				System.out.println("Airline id: "+airline.getId()+" Airline Name: "+airline.getName());				
			}
			
			logger.trace("List all the airlines that use A380 airplanes:");
			List<Flight> flightss = em.createQuery("Select f from Flight f join f.airplane f1 join f.airline f2 where f1.model='747' and f2.name <>'Star Alliance' ").getResultList();
			System.out.println("<----------------All fights using 747 planes that don’t belong to ‘Star Alliance’------------------>");
			logger.trace(String.format("%-9s%-31s%-31s", "Flight:", "Departs:",
					"Arrives:"));
			for (Flight flight : flightss) {
				logger.trace(String.format(
						"%-7s  %-12s %7s %8s  %-12s %7s %8s",
						flight.getId(),
						flight.getFlightnr(), flight.getOrigin().getCity(),
						flight.getDepartureDate(), flight.getDepartureTime(),
						flight.getDestination().getCity(),
						flight.getArrivalDate(), flight.getArrivalTime()));
			}
			
			logger.trace("All flights leaving before 12pm on 08/07/2009");
			List<Flight> flightsss = em.createQuery("Select f from Flight f where departureTime < '24:00:00' and departureDate = '2009-08-07' ").getResultList();
			System.out.println("<----------------All flights leaving before 12pm on 08/07/2009------------------>");
			logger.trace(String.format("%-9s%-31s%-31s", "Flight:", "Departs:",
					"Arrives:"));
			for (Flight flight : flightsss) {
				logger.trace(String.format(
						"%-7s  %-12s %7s %8s  %-12s %7s %8s",
						flight.getId(),
						flight.getFlightnr(), flight.getOrigin().getCity(),
						flight.getDepartureDate(), flight.getDepartureTime(),
						flight.getDestination().getCity(),
						flight.getArrivalDate(), flight.getArrivalTime()));
			}
			
			tx.commit();
		} catch (PersistenceException e) {
			if (tx != null) {
				logger.error("Rolling back:", e);
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}

	public static void fillDataBase() {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {

			Airport mco = new Airport("MCO", "Orlando", "Florida", "USA");
			Airport mia = new Airport("MIA", "Miami", "Florida", "USA");

			Airplane airplane1 = new Airplane("56789", "A380", 519);

			Airline airline1 = new Airline("Delta");

			Flight flight1 = new Flight("DE 36", "08/06/2009", "7:10 pm",
					"06/25/2015", "9:00 am", airline1, mia, mco, airplane1);

			em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			em.persist(flight1);

			tx.commit();
			
		} catch (PersistenceException e) {
			if (tx != null) {
				logger.error("Rolling back", e);
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

}
