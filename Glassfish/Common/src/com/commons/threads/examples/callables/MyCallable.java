package com.commons.threads.examples.callables;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		// return the current name of the thread 
		return Thread.currentThread().getName();
	}

}
