package com.commons.threads.examples.cajera;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Date;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Main {

	public static void main(String[] args) {

		/*Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });

		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
		Cajera cajera1 = new Cajera("Cajera 1", cliente1, initialTime);
		Cajera cajera2 = new Cajera("Cajera 2", cliente2, initialTime);

		cajera1.start();
		cajera2.start();*/
		
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.remove(new Integer(2));
		
		List<String> strings = new ArrayList<String>();
		strings.add("Cliente 1");
		strings.add("Cliente 2");
		strings.remove(null);
		
		String cliente2 = "Cliente 2";
		String cliente3 = new String("Cliente 2");
		
		String conversString = Arrays.toString(new String[]{"Cliente 3","Cliente 2","Cliente 5","Cliente 22" });
		String[] sortedArray = new String[]{"Cliente 3","Cliente 2","Cliente 5","Cliente 22" };
		
		Arrays.sort(sortedArray);
		
		LocalDate date = LocalDate.now();
		LocalTime time  = LocalTime.now();
		LocalDateTime dateTime = LocalDateTime.now();
		
		DateTimeFormatter shortFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		
		System.out.println(numbers);
		System.out.println(strings);
		System.out.println(cliente2 == cliente3 );
		System.out.println(conversString);
		System.out.println(sortedArray);
		System.out.println(date);
		System.out.println(date.minusDays(2));
		System.out.println(shortFormat.format(date));
		System.out.println(time);
		System.out.println(dateTime);
		System.out.println(shortFormat.format(dateTime));
		
		
		
	}
}
