package com.spring.calculator.impl;

import com.spring.calculator.interfaces.MathOperation;

public class MathOperationAdd implements MathOperation {

	public double calculate(double firstNumber, double secondNumber) {
		return firstNumber + secondNumber;
	}

}
