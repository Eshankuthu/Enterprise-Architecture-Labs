package edu.mum.hw2.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="ProductOrder")
public class Order {
	
	@Id @GeneratedValue
	private int orderid;
	
	private LocalDate date;
	
	@ElementCollection
	public List<OrderLine> orderLine = new ArrayList<>();
	
	public List<OrderLine> getOrderLine() {
		return orderLine;
	}
	public void setOrderLine(List<OrderLine> orderLine) {
		this.orderLine = orderLine;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	

}
