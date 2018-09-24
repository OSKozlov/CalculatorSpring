package com.spring.calculator.main;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.calculator.Calculator;
import com.spring.calculator.impl.MathOperationAdd;
import com.spring.calculator.impl.MathOperationDivision;
import com.spring.calculator.impl.MathOperationMultiply;
import com.spring.calculator.impl.MathOperationSubtraction;
import com.spring.calculator.interfaces.MathOperation;

public class Start {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		MathOperationAdd mathOperationAdd = (MathOperationAdd) context.getBean("mathOperationAdd");
		MathOperationDivision mathOperationDivision = (MathOperationDivision) context.getBean("mathOperationDivision");
		MathOperationMultiply mathOperationMultiply = (MathOperationMultiply) context.getBean("mathOperationMultiply");
		MathOperationSubtraction mathOperationSubtract = (MathOperationSubtraction) context.getBean("mathOperationSubtraction");
		
		Map<String, MathOperation> mathOperationsMap = new HashMap<>();
		mathOperationsMap.put(MathOperation.ADD, mathOperationAdd);
		mathOperationsMap.put(MathOperation.DIVISION, mathOperationDivision);
		mathOperationsMap.put(MathOperation.MULTIPLY, mathOperationMultiply);
		mathOperationsMap.put(MathOperation.SUBTRACTION, mathOperationSubtract);
		
		Calculator calculator = (Calculator) context.getBean("calculator");
		calculator.setMathOperationsMap(mathOperationsMap);
		
		double result = calculator.makeCalculation(4, 3, MathOperation.MULTIPLY);
		System.out.println("### result: " + result);
	}
}
