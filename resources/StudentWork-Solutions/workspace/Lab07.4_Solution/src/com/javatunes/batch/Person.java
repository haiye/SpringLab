/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.batch;

import java.util.ArrayList;
import java.util.List;

//  A simple value class just for testing
public class Person {
	
	private String firstName;
	private String lastName;
	
	public Person(String first, String last) {
		setFirstName(first);
		setLastName(last);
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
	
	public String toString() {
		return String.format("first: %s, last: %s",  firstName, lastName);
	}
	
	private static List<Person> persons = new ArrayList<Person>(4);
	public static List<Person> getPersons() { return persons; }
	static {
		persons.add(new Person("John", "Doe"));
		persons.add(new Person("Jane", "Deer"));
		persons.add(new Person("Jim", "Bear"));
		persons.add(new Person("Jill", "Hare"));
	}	
}
