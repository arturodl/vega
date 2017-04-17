package com.commons.threads.examples.hilos;

import com.commons.threads.examples.hilos.waitnotifier.Message;
import com.commons.threads.examples.hilos.waitnotifier.Notifier;
import com.commons.threads.examples.hilos.waitnotifier.Waiter;

public class MainThreads {
	
	public static void main(String[] args){
		Message msg = new Message("process it");
		Waiter waiter1 = new Waiter(msg);
		new Thread(waiter1, "waiter1").start();
		
		Waiter waiter2 = new Waiter(msg);
		new Thread(waiter2, "waiter2").start();
		
		Notifier notifier = new Notifier(msg);
		new Thread(notifier, "notifier").start();
		
		System.out.println("All threads are started");
	}
	
	/*
	public static void main(String[] args){
		Producer producer = new Producer();
		producer.start();
		new Consumer(producer).start();
	}
	
	
	public static void main (String[] args){
		ProcessB processB = new ProcessB();
		processB.start();
		
		System.out.println("El total es: "+processB.total);
	}
	
	
	public static void main(String[] args){
		ProcessA procesoA = new ProcessA();
		procesoA.start();
		
		synchronized(procesoA){
			try{
				System.out.println("Esperando a que termine el procesoA");
				procesoA.wait();
			}catch(InterruptedException e){
				e.printStackTrace();				
			}
			System.out.println("Total is: "+procesoA.total);
		}
	}
	
	public static void main(String[] args){
		Process procesoUno = new Process("Hilo 1", System.currentTimeMillis() );
		Process procesoDos = new Process("Hilo 2", System.currentTimeMillis() );
		procesoUno.setMensaje("Mensaje para pruebas hilo 1");
		procesoDos.setMensaje("Mensaje para pruebas hilo 2");
		procesoUno.start();
		procesoDos.start();
	}*/
}
