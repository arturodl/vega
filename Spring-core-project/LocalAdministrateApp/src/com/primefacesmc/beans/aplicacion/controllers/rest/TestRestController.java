package com.primefacesmc.beans.aplicacion.controllers.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {
	
	@GetMapping("/sayHello")
	public String sayHello() {
		return "Hola desde Test Information Rest Services";
	}

	@GetMapping("/returnString")
	public String returnString() {
		return "Regresando cadena de texto para prueba";
	}
}
