package com.commons.threads.examples.hilos.processes;

public class Process extends Thread {
	private String mensaje;
	private long tiempoInicial;
	
	public Process(String nombreHilo, long tiempoInicial){
		super(nombreHilo);
		this.tiempoInicial = tiempoInicial;
	}
	
	public void run(){
		System.out.println("Inicio del proceso: "+this.getName());
		for(int i = 0; i < 20 ;i++){
			 esperar(1);
			 System.out.println(mensaje + ", Tiempo de ejecucion: "+
	                 (System.currentTimeMillis() - this.tiempoInicial) / 1000 );
		}
		System.out.println("Fin del proceso: "+this.getName());
	}
	
	public void esperar(int segundos){
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public long getTiempoInicial() {
		return tiempoInicial;
	}

	public void setTiempoInicial(long tiempoInicial) {
		this.tiempoInicial = tiempoInicial;
	}
}
