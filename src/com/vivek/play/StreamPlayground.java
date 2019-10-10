package com.vivek.play;

import java.util.function.BinaryOperator;

public class StreamPlayground {
	
	public static void main(String args[]) {
		
		BinaryOperator<Integer> binOp = BinaryOperator.maxBy((a,b) -> a.compareTo(b) < 0 ? 1 : (a == b ? 0 : -1 ) );
		
		System.out.println(binOp.apply(12, 15));
	}

}
