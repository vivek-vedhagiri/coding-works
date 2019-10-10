package com.vivek.play;

import java.util.BitSet;

public class SievePrimeNumber {
	
	public static void main(String args[]) {
		
		BitSet bit = new BitSet(100);
		bit.set(0, 100);
		
		int i = (int) Math.sqrt(100);
		int temp = i;
		while(i > 1) {
			while(temp > 0)
				bit.clear(i * temp--);
			temp = --i;
		}
		
		
		int index = 1;
		
		while((index = bit.nextSetBit(index)) > 0) {
			System.out.println(index);
			index++;
		}
			
		
	}

}
