package com.commons.examples.threads.callables;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		String threadName = Thread.currentThread().getName();
		Thread.sleep(10000);
		System.out.println("Before returning value from thread: ".concat(threadName));
		// return the current name of the thread 
		return threadName;
	}

}
