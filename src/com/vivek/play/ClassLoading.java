package com.vivek.play;

import com.sun.org.apache.bcel.internal.util.ClassLoader;

public class ClassLoading {
	
	public static void main(String args[]) {
		
		try {
			
			String str = new String("Vivek");
			
			ClassLoader.getSystemClassLoader().getParent().loadClass(ClassLoading.class.getName());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
