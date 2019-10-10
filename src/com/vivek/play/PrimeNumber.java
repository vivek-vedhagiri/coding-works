package com.vivek.play;

import java.util.stream.IntStream;

public class PrimeNumber {
	
	public static void main(String args[]) {
		
		IntStream.range(0, 101).forEach(n -> determine(n));
		
	}
	
	public static void determine(int n) {
		
		int sqrt = (int) Math.sqrt(Math.abs(n));
		
		while (sqrt > 1) {
			if (n % sqrt == 0) {
				System.out.println(n + ": No! :(");
				return;
			}
			--sqrt;
		}
		
		System.out.println(n + ": Yes!");
		
	}
	

}
