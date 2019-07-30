package com.commons.examples.generic.classes;

import java.util.ArrayList;
import java.util.List;

import com.commons.examples.generic.interfaces.GenericInterface;

public class GenericInterfaceImpl implements GenericInterface<Integer, Double, String> {
	
	private Integer firstValue;
	private Double secondValue;
	private String thirdValue;
	
	public GenericInterfaceImpl(Integer first, Double second, String third ) {
		this.firstValue = first;
		this.secondValue = second;
		this.thirdValue = third;
	}
	
	public GenericInterfaceImpl(Integer first ) {
		this.firstValue = first;
	}

	@Override
	public Integer returnFirstValue() {
		// TODO Auto-generated method stub
		return this.firstValue;
	}

	@Override
	public void consumeSecondValue(Double s) {
		// TODO Auto-generated method stub
		this.secondValue = s;
		System.out.println("Consuming second value, which its value is: "+this.secondValue);
	}

	@Override
	public String transformFirstIntoThird(Integer f, String t) {
		// TODO Auto-generated method stub
		t = String.valueOf(f);
		return t;
	}
	
	@Override
	public <A> A addSecondIntoList(Double s, List<? super Number> list) {
		// TODO Auto-generated method stub
		int lastElement = 0;
		for(Object number: list) {
			System.out.println("Element in listing: "+number);
			lastElement++;
		}
		//Object lastObject = ;
		return (A) list.get(--lastElement);
	}
	
	public static void main(String[] args) {
		GenericInterfaceImpl gen = new GenericInterfaceImpl(5);
		Integer integer = gen.returnFirstValue();	
		String string = new String();
		System.out.println("Returning first value which is: "+integer);
		gen.consumeSecondValue(25.698);
		string = gen.transformFirstIntoThird(integer, string);
		System.out.println("Printing third value which is: "+string+" as string");
		
		List<? super Number> list = new ArrayList<>();
		list.add(2);
		list.add(3.5);
		list.add(6523.325626f);
		System.out.println("Fetching the last element from method: "+ gen.addSecondIntoList(57.8, list));
	}

	


}
