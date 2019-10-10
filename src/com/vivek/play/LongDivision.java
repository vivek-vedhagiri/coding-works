package com.vivek.play;

public class LongDivision {
	
	public static void main(String args[]) {
		
		final long micros = 24 * 60 * 60 * 1000 * 100;
		final long millis = 24 * 60 * 60 * 1000;
		
		System.out.println(micros);
		System.out.println(millis);
		
		System.out.println(micros / millis);
		
	}

}
