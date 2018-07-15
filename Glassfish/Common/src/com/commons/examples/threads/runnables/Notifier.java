package com.commons.examples.threads.runnables;

public class Notifier implements Runnable {
	
	private Message msg;
	
	public Notifier(Message msg){
		this.msg = msg;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String nameThread = Thread.currentThread().getName();
		System.out.println(nameThread + " started");
		
		try{
			Thread.sleep(1000);
			synchronized (msg){
				msg.setMsg(nameThread + " Notified work done");
				//msg.notify();
				msg.notifyAll();
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	public Message getMsg() {
		return msg;
	}

	public void setMsg(Message msg) {
		this.msg = msg;
	}

}
