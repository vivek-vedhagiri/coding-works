package com.vivek.play;

import java.util.Arrays;
import java.util.List;

public class Puzzle88 {
	
	public static void main(String args[]) {
		Pair p = new Pair<Object>(23,"skidoo");
		System.out.println(p.first().getClass().getName() + "  " + p.second().getClass().getName());
		//p.stringList().stream().forEach(i -> System.out.println(i+" "));
		
		//String[] arr = new String[] {"first","second"};
		
		//Arrays.asList(arr);
		//List<String> asList = Arrays.asList(arr);;
		
		//asList.add("third");
		
		//arr[1] = "third";
		
		//System.out.println(asList);
		
		//for(String s : p.stringList()) System.out.println( s + " ");
	}

}

class Pair<T> {
	
	private final T first;
	private final T second;
	
	public Pair(T first, T second) {
		this.first = first;
		this.second = second;
	}
	
	public T first() {
		return first;
	}
	
	public T second() {
		return second;
	}
	
	public List<String> stringList(){
		 return Arrays.asList(String.valueOf(first),String.valueOf(second));
		//return Arrays.asList("first","second");
	}
	
}
