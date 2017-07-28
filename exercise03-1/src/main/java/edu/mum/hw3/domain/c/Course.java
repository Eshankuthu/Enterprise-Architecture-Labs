package edu.mum.hw3.domain.c;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {

	@Id @GeneratedValue
	private int id;
	private String courseNumber;
	private String name;
	
	@ManyToMany(mappedBy="courseList")
	private Collection<Student> studentList = new ArrayList<>(); 
	
	public Collection<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(Collection<Student> studentList) {
		this.studentList = studentList;
	}
	
	public String getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
