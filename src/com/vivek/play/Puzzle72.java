package com.vivek.play;

public class Puzzle72 {
	
	public static void main(String args[]) {
		System.out.println(DoubleJeopardy.PRIZE);
	}

}

class Jeopardy {
	public static final String PRIZE = "$64,000";
}

class DoubleJeopardy extends Jeopardy {
	public static final String PRIZE = "2 cents";
}
