package com.vivek.algo;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	
	public static void main(String args[]) {
		
		int arr[] = new int[100];
		
		Random ran = new Random();
		
		for(int i=0;i<arr.length;i++) arr[i] = ran.nextInt(100);
		
		System.out.println(Arrays.toString(arr));
		
		sort(arr,0,arr.length-1);
		
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static void sort(int[] arr, int left, int right) {
		
		if(left >= right) return;
		
		int pos = left + ((right - left) / 2);
		int temp = 0;
		int pivot = arr[pos];
		
		int origStart = left;
		int origEnd = right;
		
		while (left <= right) {
			
			while(arr[left] <  pivot) left++;
			while(arr[right] >  pivot) right--;
			
			if(left <= right) {
				temp = arr[right];
				arr[right] = arr[left];
				arr[left] = temp;
				
				left++;
				right--;
			}
		}
		
		if(origStart < right)
			sort(arr,origStart,right);
		if(left < origEnd)
			sort(arr,left,origEnd);
		
	}

}
