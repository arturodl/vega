package com.commons.threads.examples.hilos.processes;

public class Consumer extends Thread{
	Producer producer;
	
	public Consumer(Producer producer){
		this.producer = producer;
	}
	
	public void run(){
		try{
			while(true){
				String message = producer.getMessage();
				System.out.println("Got message: "+message);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
