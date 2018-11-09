package com.commons.examples.testing;

import com.commons.examples.inheritance.Employee;
import com.commons.examples.inheritance.Person;
import com.commons.examples.inheritance.anotherpackage.Taxpayer;

public class TestClasses {
	public static void main(String [] args) {
		System.out.println("Starting TestClasses");
		//Employee employee = new Employee();
		//Taxpayer taxpayer = new Taxpayer("","",'O');
		//taxpayer.displayAges();
		//taxpayer.displayHis();
		testClassesCasting();
		
		
		
		
	}
	
	public static void testClassesCasting(){
		Person person = new Person();
		Employee employee = new Employee();
		Taxpayer taxpayer = new Taxpayer("", "",'O');
		
		person = employee;
		((Employee)person).getCurp();
	}
	
	public static void testPrimiviteCasting(){
		byte myByte = 20;		
		short myShort = 5000;
		int myInt = 600000;
		long myLong = 60000000;
		
		System.out.println(myInt + myByte);
		System.out.println(myInt + myShort);
		System.out.println(myLong + myShort);
		System.out.println(myLong + myInt);		
		System.out.println(myByte * myByte);
		
		displayByte((byte)myInt);
		
		displayInt(myByte);
		displayInt(myShort);
		displayInt((int)myLong);
	}
	
	public static void displayByte(byte myByte){
		System.out.println("Displaying Byte: "+myByte);
	}
	
	public static void displayInt(int myInt){
		System.out.println("Displaying Int: "+myInt);
	}
}
