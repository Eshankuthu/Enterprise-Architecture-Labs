package edu.mum.hw3.domain.a;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {

	@Id @GeneratedValue
	private int id;
	private String name;
	
	@OneToMany(mappedBy="department",cascade=CascadeType.PERSIST)
	Collection<Employee> employeeList = new ArrayList<Employee>();
	
	public Collection<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(Collection<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
