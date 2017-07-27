package edu.mum.hw2.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	
	@Id @GeneratedValue
	private int studentId;
	
	private String firstName;
	
	private String lastName;
	
	@ManyToMany
	@JoinTable(name="Student_course",
			joinColumns=@JoinColumn(name="Student_id"),
			inverseJoinColumns= @JoinColumn(name="Course_id"))
	private List<Course> course = new ArrayList<>();

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}
	

}
