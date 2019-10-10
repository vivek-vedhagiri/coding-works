package com.vivek.play;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringPermutation {
	
	public static void main(String args[]) {
		
		//System.out.println(permutations("ABCD"));
		//System.out.println(permutations("ABCD").size());
		
		System.out.println(iterative("ABC"));
		
	}
	
	public static Set<String> permutations(String str) {
		
		Set<String> perm = new HashSet<>();
		
		if(str == null) return null;
		if(str.length() == 0)  {
			perm.add(" ");
			return perm;
		}
		
		char initial = str.charAt(0);
		String rem = str.substring(1);
		
		Set<String> words = permutations(rem);
		
		for(String w : words) {
			for(int i=0;i<w.length();i++) {
				perm.add(charInsert(w, initial, i));
			}
		}
		
		return perm;
		 
	}
	
	public static String charInsert(String str, char c, int pos) {
		
		return str.substring(0, pos) + c  + str.substring(pos);
	}
	
	public static Set<String> iterative(String str){
		
		Set<String> perm = new HashSet<>(Arrays.asList(str));
		
		
		char[] arr = str.toCharArray();
		
		for(int i=0;i<arr.length;i++) {
			
		}
		
		return perm;
	}
	
}
