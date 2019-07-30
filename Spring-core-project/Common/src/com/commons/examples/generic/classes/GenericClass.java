package com.commons.examples.generic.classes;

import java.util.HashMap;
import java.util.Map;

import com.commons.examples.generic.interfaces.GenericInterface;

public class GenericClass<P,R> implements GenericInterface<String, String, Double> {
	
	private String firstValue;
	
	public GenericClass(String firstValue) {
		this.firstValue = firstValue;
	}

	@Override
	public String returnFirstValue() {
		// TODO Auto-generated method stub
		return this.firstValue;
	}

	@Override
	public void consumeSecondValue(String s) {
		// TODO Auto-generated method stub
		System.out.println("Consuming second value: "+s);
	}

	@Override
	public Double transformFirstIntoThird(String f, Double t) {
		// TODO Auto-generated method stub
		t = Double.valueOf(f);
		return t;
	}

	@Override
	public <A> A addSecondIntoList(String s, java.util.List<? super Number> list) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void consumingValuesFromP(P p) {
	   if (p instanceof Map) {
		   Map map = (Map) p;
		   System.out.println(map.get("first"));
		   System.out.println(map.get("second"));
		   System.out.println(map.get("third"));
	   }else {
		   System.out.println("Unrecognizable type");
	   }
	  
	}

	public static void main(String [] args) {
		GenericClass<Map<String, String>, Map<String, String>> genericClass = new GenericClass<Map<String, String>, Map<String, String>>("Valor Uno");
		Map<String, String> valuesInMapOne = new HashMap<String, String>();
		valuesInMapOne.put("first", "value first");
		valuesInMapOne.put("second", "value second");
		valuesInMapOne.put("third", "value third");
		
		genericClass.consumingValuesFromP(valuesInMapOne);
	}

}
