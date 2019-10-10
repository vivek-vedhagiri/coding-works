package com.vivek.play;

public class Puzzle85 {
	
	private static boolean initialized = false;
	
	static {
		
		try {
			Thread t = new Thread(() -> initialized = true);
			t.start();
			
			t.join();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		System.out.println(initialized);
	}

}
