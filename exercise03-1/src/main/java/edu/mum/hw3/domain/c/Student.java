package edu.mum.hw3.domain.c;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {

	@Id
	private int sid;
	private String firstName;
	private String lastName;
	@ManyToMany
	@JoinTable(name="STUDENT_COURSE",
			joinColumns = @JoinColumn(name="srudentID"),
			inverseJoinColumns = @JoinColumn(name="addressId"))
	private Collection<Course> courseList = new ArrayList<>();
	
	public Collection<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(Collection<Course> courseList) {
		this.courseList = courseList;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
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
	
	
}
