package com.vivek.play;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAnagram {
	
	public static void main(String args[]) {
			
		isAnagram("bVivek", "skviVe");
		isAnagram1("bVivek", "skviVe");
		isAnagram2("bVivek", "skviVe");
		
	}
	
	public static void isAnagram(String str1, String str2) {
		
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		System.out.println(Arrays.equals(arr1,arr2));
		
	}
	
	public static void isAnagram1(String str1, String str2) {
		
		StringBuilder sb = new StringBuilder(str2);
		int index = 0;
		
		for(char c: str1.toCharArray()) {
			
			index = sb.indexOf(c+"");
			if(index >= 0)
				sb.deleteCharAt(index);
			else  
				{ System.out.println(false); return; }
		}
		
		System.out.println(sb.length() == 0); 
		
		
		
	}
	
	public static void isAnagram2(String str1, String str2) {
		
		List<Character> chars = new ArrayList<>();
		
		for(char c :str1.toCharArray()) chars.add(c);
		for(char c: str2.toCharArray()) chars.remove((Character)c);
		
		System.out.println(str1.length() == str2.length() && chars.size() == 0);
	}

}
