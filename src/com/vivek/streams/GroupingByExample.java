package com.vivek.streams;

import static java.util.stream.Collectors.groupingBy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class GroupingByExample {
	
	public static void main(String args[]) {
		
		List<BlogSpot> list = new ArrayList<>();
		
		list.add(new BlogSpot("Vivek", "Life", "LifeStyle",new BigDecimal("200")));
		list.add(new BlogSpot("Anitha", "Wife", "WifeStyle",new BigDecimal("100")));
		list.add(new BlogSpot("Nethrah", "Sissy", "LifeStyle",new BigDecimal("300")));
		list.add(new BlogSpot("Rudhrah", "LittleSissy", "LifeStyle",new BigDecimal("400")));
		list.add(new BlogSpot("Vivek", "Java", "Tech",new BigDecimal("500")));
		list.add(new BlogSpot("Vivek", "Oracle", "Tech",new BigDecimal("250")));
		list.add(new BlogSpot("Anitha", "Testing", "Tech",new BigDecimal("350")));
		list.add(new BlogSpot("Nethrah", "Mommy", "WifeStyle",new BigDecimal("450")));
		list.add(new BlogSpot("Rudhrah", "Legos", "Tech",new BigDecimal("550")));
		
		//System.out.println(list);
		
		//groupingBy
		//Map<String,List<BlogSpot>> map = list.stream().collect(groupingBy(BlogSpot::getContentType));
		
		//ConcurrentMap<String,List<BlogSpot>> map = list.parallelStream().collect(Collectors.groupingByConcurrent( b -> b.getContentType()));
		Map<String,List<BlogSpot>> map = list.stream().collect(Collectors.groupingBy( b -> b.getContentType()));
		
		System.out.println(map);
		
		//complex grouping by with object as key.
		Map<Tuple,List<BlogSpot>> tupleMap = list.stream().collect(groupingBy(post -> new Tuple(post.getContentType(),post.getAuthor())));
		
		//System.out.println(tupleMap);
		
		//set of blog spot with groupingby instead the list
		Map<String,Set<BlogSpot>> blogSet = list.stream().collect(groupingBy( b -> b.getContentType(), Collectors.toSet()));
		
		//System.out.println(blogSet);
		
		//multiple groupingby
		Map<String, Map<String, Set<BlogSpot>>> mapsOfMaps = list.stream().collect(groupingBy( b -> b.getContentType(), groupingBy(b -> b.getAuthor(), Collectors.toSet())));
		
		//System.out.println(mapsOfMaps);
		
		//grouping aggregate
		Map<String, Double> averages = list.stream().collect(Collectors.groupingBy(BlogSpot::getAuthor,Collectors.averagingInt(b -> b.getPrice().intValue())));
		Map<String, Integer> sum = list.stream().collect(Collectors.groupingBy(BlogSpot::getAuthor,Collectors.summingInt(b -> b.getPrice().intValue())));
		Map<String, Optional<BlogSpot>> max = list.stream().collect(Collectors.groupingBy(BlogSpot::getAuthor,Collectors.maxBy((v1,v2) -> v1.getPrice().compareTo(v2.getPrice()))));
		Map<String, Optional<BlogSpot>> min = list.stream().collect(Collectors.groupingBy(BlogSpot::getAuthor,Collectors.minBy((v1,v2) -> v1.getPrice().compareTo(v2.getPrice()))));
		
		Map<String, Optional<BlogSpot>> maxUsingComparator = list.stream().collect(Collectors.groupingBy(BlogSpot::getAuthor,Collectors.maxBy(Comparator.comparingInt(v -> v.getPrice().intValue()))));
		
		/*
		System.out.println(averages);
		System.out.println(sum);
		System.out.println(max);
		System.out.println(maxUsingComparator);
		System.out.println(min);
		*/
		
		//Mapping grouped results to a different type.
		
		Map<String, String> concatenated = list.stream().collect(Collectors.groupingBy(BlogSpot::getAuthor,Collectors.mapping(BlogSpot::getTitle,Collectors.joining(", ", "[", "]"))));
		
		//System.out.println(concatenated);
		
		
	}

}

class Tuple {
	
	Tuple(String type, String author){
		this.type = type;
		this.author = author;
	}
	
	String type;
	String author;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tuple other = (Tuple) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
}
