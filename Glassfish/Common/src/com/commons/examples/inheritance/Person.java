package com.commons.examples.inheritance;

public class Person {
	protected String firstname;
	{
		System.out.println("Before initializing the lastname: ");
	}
	protected String lastname;
	protected char gender;
	protected int age;
	{
		System.out.println("Before initializing the common");
	}
	String common;
	
	public Person() {
		System.out.println("Creating Person");
	}
	
	{
		System.out.println("All initializations are done");
	}
	
	public void hiFromPerson() {
		System.out.println("Hi from Person: ");
	}
}
