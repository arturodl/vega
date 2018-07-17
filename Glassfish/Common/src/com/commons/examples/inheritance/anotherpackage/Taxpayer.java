package com.commons.examples.inheritance.anotherpackage;

import com.commons.examples.inheritance.Person;
import com.commons.examples.interfaces.CanBorrow;

public class Taxpayer extends Person implements CanBorrow{
	private String rfc;
	private int seniority;
	private final int initialMoney;
	private final static int moneyToSpend;
	
	{
		System.out.println("We initialize the instance initial money");
		initialMoney = 500;		
	}
	
	static {		
		System.out.println("We initialize the static money to spend");
		moneyToSpend = 500;
	}
	
	public Taxpayer(String rfc, int seniority) {
		this.rfc = rfc;
		this.seniority = seniority;		
	}	
	
	public Taxpayer(String firstname, String lastname, char gender) {
		System.out.println("Creating the taxpayer");
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		super.age = 20;
		this.age = 25;
	}
	
	public void displayAges() {
		System.out.println("Displaying age from parent: "+super.age);
		System.out.println("Displaying age from child: "+this.age);
	}
	
	public void displayHis() {
		super.hiFromPerson();
		this.hiFromPerson();
	}
	
	@Override
	public void hiFromPerson() {
		System.out.println("Hi from TaxPayer");
	}
	
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public int getSeniority() {
		return seniority;
	}
	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}	

	{
		System.out.println("All instance initializations are done");
		System.out.println("the instance initial money: "+initialMoney);
	}	
	
	static{
		System.out.println("All static initializations are done");
		System.out.println("the static money to spend: "+moneyToSpend);
	}

	@Override
	public int getNewMaximumBorrow() {
		// TODO Auto-generated method stub
		return 0;
	}
}
