package com.vivek.threading;

import java.util.Random;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ProducerConsumer {
	
	static class Producer implements Callable<String> {
		
		private Random random = new Random(1000L);
		private BlockingQueue<String> queue;
		
		public Producer(BlockingQueue<String> queue) {
			this.queue = queue;
		}
		
		@Override
		public String call() throws Exception {
			
			try {
				while(true) {
					
					System.out.println("Producer Generates...");
					queue.offer("Printing from Queue : " + random.nextInt());
					//Thread.sleep(200);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw e;
			}
		}
		
	}

	static class Consumer implements Callable<String> {
		
		private BlockingQueue<String> queue;
		
		public Consumer(BlockingQueue<String> queue) {
			this.queue = queue;
		}
		
		@Override
		public String call() throws Exception {
			try {
				while(true)  {
					System.out.println(Thread.currentThread().getName() +" prints : " + queue.take());
				}
			} catch(Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
		
	}
	
	public static void main(String args[]) {
		
		ExecutorService pool = Executors.newFixedThreadPool(5);
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(20);
		
		Future[] futures = new Future[5];
		
		futures[0] = pool.submit(new Producer(queue));
		futures[1] = pool.submit(new Consumer(queue));
		futures[2] = pool.submit(new Consumer(queue));
		futures[3] = pool.submit(new Consumer(queue));
		futures[4] = pool.submit(new Consumer(queue));
		
		while(!(futures[1].isDone() && futures[2].isDone() && futures[3].isDone() && futures[4].isDone())){
			
		}
		
		System.out.println("All the consumers are dead! killing the producer");
		
		futures[0].cancel(true);
		
		pool.shutdown();
		
		System.out.println("All done!");
		
	}

}

