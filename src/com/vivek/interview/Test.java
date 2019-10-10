package com.vivek.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
	
	public static void main(String args[]) {
		
		List<String> list = Stream.of("foo","boo","coo").collect(Collectors.toList());
		
		List<String> list1 = new ArrayList<String>();
		
	}

}
