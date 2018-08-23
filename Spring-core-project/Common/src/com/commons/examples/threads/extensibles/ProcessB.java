package com.commons.examples.threads.extensibles;

public class ProcessB extends Thread{
	int total;
	
	public void run(){
		for (int i = 0; i < 100; i++){
			total = total + i;
		}
	}
}
