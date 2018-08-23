package com.commons.examples.threads.extensibles;

public class ProcessA extends Thread {
	 int total;
	 
	 public void run(){
		 synchronized(this){
			 for(int i = 0; i < 100; i++){
				 total += i;
			 }
			 notify();
		 }
	 }
}
