package com.vivek.play;

import java.util.HashSet;
import java.util.Set;

public class StringPalindrome {
	
	public static void main(String args[]) {
		System.out.println(isPalindrome("AllabbaallA"));
		System.out.println(longestPalindrome("AlllabxballA"));
	}
	
	public static boolean isPalindrome(String str) {
		
		int start = 0;
		int end = str.length()-1;
		
		while(start < end) {
			if(str.charAt(start) == str.charAt(end)) {
				start++;end--;
				continue;
			}
			
			return false;
		}
		
		return true;
		
	}
	
	public static String longestPalindrome(String str) {
		
		Set<String> palindromes = new HashSet<>();
		int charPos = 0;
		
		for(int i=0;i<str.length();i++) {
			
			charPos = i;
			String p = null;
			
			while( (charPos = str.indexOf(str.charAt(i), charPos+1)) >= 0) {
				p = str.substring(i,charPos+1);
				
				if(isPalindrome(p)) palindromes.add(p);
			}
		}
		
		return palindromes.stream().max((e1,e2) -> e1.length() - e2.length()).orElse("No Palindrome!");
	}

}
