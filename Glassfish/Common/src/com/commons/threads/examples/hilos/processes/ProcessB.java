package com.commons.threads.examples.hilos.processes;

public class ProcessB extends Thread{
	int total;
	
	public void run(){
		for (int i = 0; i < 100; i++){
			total = total + i;
		}
	}
}
