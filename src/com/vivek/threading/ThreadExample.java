package com.vivek.threading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadExample {
	
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		
		ExecutorService ex = Executors.newFixedThreadPool(5);
		
		System.out.println(Thread.currentThread().getName() + " is Printing this");
		
		Future<String> f = ex.submit(() -> {Thread.sleep(3000);return Thread.currentThread().getName() + " is Printing this";});
		/*
		 * ex.submit(() -> System.out.println(Thread.currentThread().getName() +
		 * " is Printing this")); ex.submit(() ->
		 * System.out.println(Thread.currentThread().getName() + " is Printing this"));
		 * ex.submit(() -> System.out.println(Thread.currentThread().getName() +
		 * " is Printing this")); ex.submit(() ->
		 * System.out.println(Thread.currentThread().getName() + " is Printing this"));
		 * ex.submit(() -> System.out.println(Thread.currentThread().getName() +
		 * " is Printing this")); ex.submit(() ->
		 * System.out.println(Thread.currentThread().getName() + " is Printing this"));
		 * ex.submit(() -> System.out.println(Thread.currentThread().getName() +
		 * " is Printing this")); ex.submit(() ->
		 * System.out.println(Thread.currentThread().getName() + " is Printing this"));
		 * ex.submit(() -> System.out.println(Thread.currentThread().getName() +
		 * " is Printing this")); ex.submit(() ->
		 * System.out.println(Thread.currentThread().getName() + " is Printing this"));
		 */
		
		System.out.println(f.get());
		
		System.out.println("After the future get call");
		
		ex.shutdown();
		
		
		
	}

}
