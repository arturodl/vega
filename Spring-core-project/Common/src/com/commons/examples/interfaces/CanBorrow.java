package com.commons.examples.interfaces;

public interface CanBorrow {
	
	public int maximumBorrow = 20;
	
	public int getNewMaximumBorrow();
	
	static void displayCanBorrowInformation() {
		System.out.println("This Interface enables Classes to borrow");
	}
}
