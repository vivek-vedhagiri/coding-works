package com.vivek.play;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringPermutationTest {
	
	public static void main(String args[]) {
		
		System.out.println(Arrays.toString(permutation("ABCD")));
		
	}
	
	public static String[] permutation(String str) {
		
		if(str == null || str.trim().length() == 0)
			return new String[] {" "};
		
		char c = str.charAt(0);
		String[] strs = permutation(str.substring(1));
		
		Set<String> output = new HashSet<>();
		
		for(int i=0;i<strs.length;i++) {
			for(int j=0;j<strs[i].length();j++) {
				output.add(strs[i].substring(0, j)+c+strs[i].substring(j));
			}
			
		}
		
		return output.toArray(new String[output.size()]);
		
		
	}

}
