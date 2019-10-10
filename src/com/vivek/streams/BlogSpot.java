package com.vivek.streams;

import java.math.BigDecimal;

public class BlogSpot {
	
	private String author;
	private String title;
	private String contentType;
	private BigDecimal price;
	
	public BlogSpot(String author, String title, String contentType, BigDecimal price) {
		super();
		this.author = author;
		this.title = title;
		this.contentType = contentType;
		this.price = price;
	}
	
	public String getAuthor() {
		return author;
	}
	public String getTitle() {
		return title;
	}
	public String getContentType() {
		return contentType;
	}
	
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "BlogSpot [author=" + author + ", title=" + title + ", contentType=" + contentType + ", price=" + price
				+ "]";
	}
	
}
