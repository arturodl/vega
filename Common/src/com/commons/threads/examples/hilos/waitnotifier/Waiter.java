package com.commons.threads.examples.hilos.waitnotifier;

public class Waiter implements Runnable {

	private Message msg;
	
	public Waiter(Message msg){
		this.msg = msg;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String nameThread = Thread.currentThread().getName();
		
		synchronized(msg){
			try{
				System.out.println(nameThread + 
								" waiting to get notified at time: "+
								 System.currentTimeMillis());
				msg.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
			System.out.println(nameThread + 
							" waiter thread got notified at time: "+
							System.currentTimeMillis());
			System.out.println(nameThread + " processed: " + msg.getMsg());
		}
	}

}
