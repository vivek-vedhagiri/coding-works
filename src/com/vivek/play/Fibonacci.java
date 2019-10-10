package com.vivek.play;

public class Fibonacci {
	
	public static void main(String args[]) {
		
		printFib(0, 1);
		
	}
	
	public static void printFib(int x, int y) {
		
		if(x > 100) return;
		
		System.out.println(x+y);
		
		printFib(y, x+y);
	}

}
