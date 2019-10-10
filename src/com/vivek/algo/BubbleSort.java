package com.vivek.algo;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
	
	public static void main(String args[]) {
		
		int[] arr = new int[10];
		
		Random ran = new Random();
		for(int i=0;i<arr.length;i++) arr[i] = ran.nextInt(10);
		
		System.out.println(Arrays.toString(sort(arr)));
		
	}
	
	public static int[] sort(int[] arr) {
		
		boolean swap = true;
		int temp = 0;
		
		while(swap) {
			swap = false;
			for(int i=1;i<arr.length;i++) {
				if(arr[i-1] > arr[i] ) {
					temp = arr[i-1];
					arr[i-1] = arr[i];
					arr[i] = temp;
					swap = true;
				}
			}
		}
		
		return arr;
		
	}

}
