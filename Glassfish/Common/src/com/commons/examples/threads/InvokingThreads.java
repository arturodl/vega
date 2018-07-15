package com.commons.examples.threads;

import com.commons.examples.threads.extensibles.Process;

public class InvokingThreads {
	
	public static void main(String[] args){
		Process procesoUno = new Process("Hilo 1", System.currentTimeMillis() );
		Process procesoDos = new Process("Hilo 2", System.currentTimeMillis() );
		procesoUno.setMensaje("Mensaje para pruebas hilo 1");
		procesoDos.setMensaje("Mensaje para pruebas hilo 2");
		procesoUno.start();
		procesoDos.start();
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
	
	*/
}
