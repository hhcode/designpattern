package com.huang.designpattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class TestThread {
	@Test
	public void testThreadPool() {
		ExecutorService pools = Executors.newCachedThreadPool();
		pools.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("--- go ---");
			}
		});
	}
	
}
