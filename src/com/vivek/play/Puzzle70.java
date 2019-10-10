package com.vivek.play;

import com.vivek.comparator.CodeTalk;

public class Puzzle70 {
	
	private static class ClickIt extends CodeTalk {
		protected void printMessage() {
			System.out.println("Hack");
		}
	}
	
	public static void main(String args[]) {
		ClickIt c = new ClickIt();
		c.doIt();
	}

}
