package com.vivek.play;

public class Puzzle84 {
	
	public static void main(String args[]) {
		
		Thread.currentThread().interrupt();
		
		if(Thread.interrupted()) {
			System.out.println("Interruped : " + Thread.interrupted());
		} else {
			System.out.println("Not Interrupted :" + Thread.interrupted());
		}
		
	}

}
