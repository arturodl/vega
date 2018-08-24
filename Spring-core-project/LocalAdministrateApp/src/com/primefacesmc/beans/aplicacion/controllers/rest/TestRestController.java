package com.primefacesmc.beans.aplicacion.controllers.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestRestController {
	
	@GetMapping("/justSayHello")
	public String sayHello() {
		return "Hola desde Test Information Rest Services";
	}

	@GetMapping("/returnString") 
	public String returnString() {
		return "Regresando cadena de texto para prueba";
	}
	
	@GetMapping("/testMyCredentials")
	public String testMyCredentials() {
		return "Your Credentials are being allowed";
	}
}
