package com.vivek.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComparatorLambda {
	
	public static void main(String args[]) {
		
		listCompare();
		
		
	}
	
	private static void listCompare() {

		List<Human> list = Stream
				.of(new Human("Vivek", 35), new Human("Anitha", 34), new Human("Nethrah", 9), new Human("Rudhrah", 3))
				.collect(Collectors.toList());

		// List.forEach() vs Stream.forEach()

		// Sort using a static compare method
		list.sort(ComparatorLambda::compareHumans);

		list.forEach((h) -> System.out.println(h.getName()));

		// Compare using comparators with stream
		list = list.stream().sorted(Comparator.comparing(Human::getName)).collect(Collectors.toList());

		list.forEach((h) -> System.out.println(h.getName()));

		// Multiple comparion with Stream
		list = list.stream().sorted(Comparator.comparing(Human::getAge).thenComparing(Human::getName))
				.collect(Collectors.toList());

		System.out.println();

		list.stream().forEach((h) -> System.out.println(h.getName()));

	}
	
	private static int compareHumans(Human h1, Human h2) {
		return h1.getName().compareTo(h2.getName());
	}
	
	private static void listIteration() {
		
		List<Human> list = Stream
				.of(new Human("Vivek", 35), new Human("Anitha", 34), new Human("Nethrah", 9), new Human("Rudhrah", 3))
				.collect(Collectors.toList());
		
		list = Collections.synchronizedList(list);
		List<Human> copyList = new ArrayList<Human>();
		Collections.copy(copyList, list);
		
		list.forEach(e -> copyList.set(2, new Human("Gumtha", 23)));
		
	}

}

class Human {
	String name;
	int age;
	
	public Human(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}