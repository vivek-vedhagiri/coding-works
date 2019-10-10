package com.vivek.play;

public class Puzzle74 {
	
	public static void main(String args[]) {
		
		Enigma e  = new Enigma();
		System.out.println(e.equals(e));
		
	}

}

class Enigma {
	
	public boolean equals(Enigma e) {
		return false;
	}
	
}
