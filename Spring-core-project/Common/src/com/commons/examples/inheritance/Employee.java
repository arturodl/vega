package com.commons.examples.inheritance;

public class Employee extends Person{
	private String rfc;
	private String curp;
	private String imss;
	
	public Employee() {
		System.out.println("Creating Employee");
	}
	
	public Employee(String firstname, String lastname, int age) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}
	
	public Employee(String rfc, String curp, String imss) {
		this.rfc = rfc;
		this.curp = curp;
		this.imss = imss;		
	}
	
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public String getImss() {
		return imss;
	}
	public void setImss(String imss) {
		this.imss = imss;
	}
	
	
	
}
