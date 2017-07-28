package edu.mum.hw3.domain.f;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="EmployeeF")
public class Employee {

	@Id
	private int empNo;
	private String name;
	@ManyToOne
	private Office office;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Office getOffice() {
		return office;
	}
	public void setOffice(Office office) {
		this.office = office;
	}
	
	
}
