package com.vivek.threading;

public class WaitNotify {
	
	public static void main(String args[]) {
		
		Object lock = new Object();
		
		Thread waiting = new SomeThread(lock);
		
		waiting.start();
		
		System.out.println("main thread is done!");
			
	}
	
	static class SomeThread extends Thread {
		
		private Object lock;
		
		public SomeThread(Object lock) {
			this.lock = lock;
		}
		
		public void run() {
			
			synchronized(lock) {
				System.out.println("Going to release and wait for the lock!...");
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Got the lock back!...");
			}
		}
		
	}

}
