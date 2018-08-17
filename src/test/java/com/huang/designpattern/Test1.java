package com.huang.designpattern;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Test;

public class Test1 {
	
	@Test
	public void test() {
		BlockingQueue<String> queue = new LinkedBlockingQueue<>();
		queue.add("323");
	}
}
