package edu.mum.hw3.domain.e;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="CustomerE")
public class Customer {

	@Id
	@GeneratedValue
	private int id;
	private String name;

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Reservation> reservationList = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Reservation> getReservationList() {
		return reservationList;
	}

	public void setReservationList(List<Reservation> reservationList) {
		this.reservationList = reservationList;
	}

}
