package com.vivek.threading;

public class WatchDogThread {
	
	public static void main(String args[]) throws InterruptedException {
		
		Object lock = new Object();
		Thread wdog = new Thread(new WatchDog(lock));
		ThirdParty tp = new ThirdParty();
		String output = null;
		
		wdog.start();
		output = tp.aMethod();
		wdog.interrupt();
		
		System.out.println(output);
		System.out.println("Completed Sucessfully");
		
	}

}

class WatchDog implements Runnable {
	
	private Object lock;
	
	public WatchDog(Object lock) {
		this.lock = lock;
	}
	
	@Override
	public void run() {
		
		synchronized (lock) {
			try {
				lock.wait(3000);
				System.out.println("Killing the Program!");
				System.exit(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		
	}
	
}

class ThirdParty {
	
	public String aMethod() throws InterruptedException {
		Thread.sleep(3100);
		return "Here it is!";
	}
}
