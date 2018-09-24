package com.spring.calculator.interfaces;

public interface MathOperation {
	
	public static final String ADD = "+";
	public static final String SUBTRACTION = "-";
	public static final String DIVISION = "/";
	public static final String MULTIPLY = "*";

	double calculate(double firstNumber, double secondNumber);
}
