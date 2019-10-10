package com.vivek.algo;

import java.util.Arrays;

public class InsertionSort {
	
	public static void main(String args[]) {
		System.out.println(Arrays.toString(sort(new int[] {9,7,8,3,4,5,1,6,2})));
		
	}
	
	public static int[] sort(int[] arr) {
		
		int temp = 0;		
		
		for(int i=1;i<arr.length;i++) {
			for(int j=i;j>=1;j--) {
				if(arr[j-1] > arr[j]) {
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		return arr;
		
	}

}
