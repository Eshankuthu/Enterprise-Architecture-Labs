package edu.mum.hw3.domain.f;

import java.util.ArrayList;
import java.util.List;

//@Entity(name="DepartmentF")
public class Department {
	private int id;
	private String name;
	private List<Employee> employee = new ArrayList<>();
}
