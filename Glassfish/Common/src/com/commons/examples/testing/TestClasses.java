package com.commons.examples.testing;

import com.commons.examples.classes.Employee;
import com.commons.examples.classes.anotherpackage.Taxpayer;
import com.commons.examples.interfaces.CanBorrow;

public class TestClasses {
	public static void main(String [] args) {
		System.out.println("Starting TestClasses");
		//Employee employee = new Employee();
		Taxpayer taxpayer = new Taxpayer("","",'O');
		taxpayer.displayAges();
		taxpayer.displayHis();
		//testCasting();
		
		
		
		
	}
	
	public static void testCasting(){
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
