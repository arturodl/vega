package com.commons.examples.threads.extensibles;

import java.util.Vector;

public class Producer extends Thread{
	static final int MAXQUEUE = 5;
	private Vector<String> messages = new Vector<String>();
	
	public void run(){
		try{
			while(true){
				putMessage();
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	private synchronized void putMessage() throws InterruptedException{
		while (messages.size() == MAXQUEUE){
			wait();
		}
		messages.addElement(new java.util.Date().toString() );
		System.out.println("put message");
		notify();
	}
	
	public synchronized String getMessage() throws InterruptedException{
		notify();
		while(messages.size() == 0){
			wait();
		}
		String message = messages.firstElement();
		messages.removeElement(message);
		return message;
	}
	
	public Vector<String> getMessages() {
		return messages;
	}
	public void setMessages(Vector<String> messages) {
		this.messages = messages;
	}

}
