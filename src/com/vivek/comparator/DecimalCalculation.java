package com.vivek.comparator;

import java.math.BigDecimal;

public class DecimalCalculation {
	
	public static void main(String args[]) {
		
		calculate();
		
	}
	
	public static void calculate() {
		
		//double a = 2.00;
		//double b = 1.10;
		
		BigDecimal a = new BigDecimal("2.00");
		BigDecimal b = new BigDecimal("1.10");
		
		System.out.println(a.subtract(b));
		
	}

}
