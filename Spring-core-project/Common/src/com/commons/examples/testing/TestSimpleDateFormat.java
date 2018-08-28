package com.commons.examples.testing;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSimpleDateFormat {
	
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static void main(String args[]) {
		String textoFecha = "2009-02-07 02:";
		Date fechaConFormato = null;
		try {
			fechaConFormato = simpleDateFormat.parse(textoFecha);
			System.out.println("fechaConFormato: "+fechaConFormato);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
