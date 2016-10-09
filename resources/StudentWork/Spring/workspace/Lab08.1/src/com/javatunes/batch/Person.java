/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.batch;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//  A simple value class just for testing
public class Person {
	
	private String firstName;
	private String lastName;
	private BigDecimal salary;
	
	public Person() {}
	
	public Person(String first, String last, BigDecimal Salary) {
		setFirstName(first);
		setLastName(last);
		setSalary(salary);
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

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return String.format("first: %s, last: %s",  firstName, lastName);
	}
	
	private static List<Person> persons = new ArrayList<Person>(4);
	public static List<Person> getPersons() { return persons; }
	static {
		persons.add(new Person("John", "Doe", new BigDecimal("2500")));
		persons.add(new Person("Jane", "Deer", new BigDecimal("5000")));
		persons.add(new Person("Jim", "Bear", new BigDecimal("2000")));
		persons.add(new Person("Jill", "Hare", new BigDecimal("4000")));
	}
}
