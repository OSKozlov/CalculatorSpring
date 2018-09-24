package com.spring.calculator;

import java.util.Map;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.spring.calculator.interfaces.MathOperation;

public class Calculator implements InitializingBean, DisposableBean {
	
	private Map mathOperationsMap; 
	
	public Calculator() {
	}
	
	public double makeCalculation(double firstNumber, double secondNumber, String operation) {
		MathOperation mathOperation = (MathOperation) mathOperationsMap.get(operation);
		double result = mathOperation.calculate(firstNumber, secondNumber);
		return result;
	}

	public Map getMathOperationsMap() {
		return mathOperationsMap;
	}

	public void setMathOperationsMap(Map mathOperationsMap) {
		this.mathOperationsMap = mathOperationsMap;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Init");
	}

}
