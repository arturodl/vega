package com.commons.threads.examples.pistola;

public class Pistola {
	private int cartucho;
	private boolean enposicion = true;
	
	public synchronized void disparar(int cartucho){
		 System.out.println("Disparar en posicion: "+enposicion);
		 while (enposicion == false) {
	            try {
	                // Esperar a apuntar
	                wait();
	            } catch (Exception e) { }
	        }
	     enposicion = false;
	     notifyAll();
	}
	
	public synchronized void apuntar(){
		System.out.println("Apuntar en posicion: "+enposicion);
		while (enposicion == true) {
            try {
                // Esperar a disparar
               wait();
            } catch (Exception e) { }
        }
        enposicion = true;
        notifyAll();
	}
}
