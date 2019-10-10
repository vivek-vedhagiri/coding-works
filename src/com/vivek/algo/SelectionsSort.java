package com.vivek.algo;

import java.util.Arrays;

public class SelectionsSort {
	
	public static void main(String args[]) {
		
		System.out.println(Arrays.toString(sort(new int[] {9,7,8,3,4,5,1,6,2,23,34,45,64,3,2,1,67,54,97,23,67})));
		
	}
	
	public static int[] sort(int[] arr) {
		
		int minPos = 0;
		int temp = 0;
		
		for(int i=0;i<arr.length;i++) {
			minPos = i;
			
			for(int j=minPos+1;j<arr.length;j++) {
				if(arr[minPos] > arr[j]) minPos = j;
			}
			
			if(minPos != i) {
				temp = arr[minPos];
				arr[minPos] = arr[i];
				arr[i] = temp;
			}
		}
		
		return arr;
		
	}

}
