package com.vivek.threading;

import java.util.Random;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ProducerConsumerWaitAndNotify {
	
	static class Producer implements Callable<String> {
		
		private Random random = new Random(1000L);
		private Stack<String> queue;
		
		public Producer(Stack<String> queue) {
			this.queue = queue;
		}
		
		@Override
		public String call() throws Exception {
			
				while(true) {
					
					synchronized (queue) {
						
						if(queue.empty()) {
							System.out.println("Producer Generates...");
							queue.push("Printing from Queue : " + random.nextInt());
						}
						
						//Thread.sleep(200);
						queue.notify();
					}
				}
			
		}
		
	}

	static class Consumer implements Callable<String> {
		
		private Stack<String> queue;
		
		public Consumer(Stack<String> queue) {
			this.queue = queue;
		}
		
		@Override
		public String call() throws Exception {
				while(true)  {
					synchronized (queue) {
						while(!queue.isEmpty()) System.out.println(Thread.currentThread().getName() + " prints : " + queue.pop());
						queue.wait();
					}
				}
		}
		
	}
	
	public static void main(String args[]) {
		
		ExecutorService pool = Executors.newFixedThreadPool(5);
		Stack<String> queue = new Stack<String>();
		
		Future[] futures = new Future[5];
		
		futures[0] = pool.submit(new Producer(queue));
		futures[1] = pool.submit(new Consumer(queue));
		futures[2] = pool.submit(new Consumer(queue));
		futures[3] = pool.submit(new Consumer(queue));
		futures[4] = pool.submit(new Consumer(queue));
		
		while(!(futures[1].isDone() && futures[2].isDone() && futures[3].isDone() && futures[4].isDone())){
			
			//System.out.println("Thread 2 is" + (futures[1].isDone() ? "Dead" : " Alive"));
			//System.out.println("Thread 3 is" + (futures[2].isDone() ? "Dead" : " Alive"));
			//System.out.println("Thread 4 is" + (futures[3].isDone() ? "Dead" : " Alive"));
			//System.out.println("Thread 5 is" + (futures[4].isDone() ? "Dead" : " Alive"));
		}
		
		System.out.println("All the consumers are dead! killing the producer");
		
		futures[0].cancel(true);
		
		pool.shutdown();
		
		System.out.println("All done!");
		
	}
	
	
	
}
