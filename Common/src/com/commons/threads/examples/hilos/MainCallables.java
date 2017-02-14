package com.commons.threads.examples.hilos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.commons.threads.examples.callables.MyCallable;

public class MainCallables {
	
	public static void main(String[] args){
		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<Future<String>> lista = new ArrayList<Future<String>>();
		
		Callable<String> callable = new MyCallable();
		Future<String> future = null;
		for(int i = 0; i < 100; i++){
			future = executor.submit(callable);
			lista.add(future);
		}
		
		for(Future<String> item: lista){
			try{
				System.out.println(new Date() + " :: "+item.get());
			}catch(InterruptedException e){
				e.printStackTrace();
			}catch(ExecutionException e){
				e.printStackTrace();
			}
		}
		
		executor.shutdown();
	}
}
