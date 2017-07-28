package edu.mum.hw3.domain.d;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	
	@Id @GeneratedValue
	private int id;
	private String name;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private Collection<Reservation> reservationList = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Reservation> getReservationList() {
		return reservationList;
	}

	public void setReservationList(Collection<Reservation> reservationList) {
		this.reservationList = reservationList;
	}
		
}
