package com.primefacesmc.beans.aplicacion.controllers.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value = "/testResponseEntityStatus/{typeStatus}", method = RequestMethod.GET)
	public ResponseEntity<Object> testResponseEntityReturningStatus(@PathVariable("typeStatus") String typeStatus ) {
		System.out.println("Entering the method with ResponseEntity");
		String advice = "If you are using POSTMAN please check out the STATUS CODE above this message";
		switch (typeStatus) {
			case "100":
				return new ResponseEntity<>(advice, HttpStatus.CONTINUE);
			case "101":
				return new ResponseEntity<>(advice, HttpStatus.SWITCHING_PROTOCOLS);
			case "102":
				return new ResponseEntity<>(advice, HttpStatus.PROCESSING);
			case "103":
				return new ResponseEntity<>(advice, HttpStatus.CHECKPOINT);
			case "200":
				return new ResponseEntity<>(advice, HttpStatus.OK);
			case "201":
				return new ResponseEntity<>(advice, HttpStatus.CREATED);
			case "202": 
				return new ResponseEntity<>(advice, HttpStatus.ACCEPTED);
			case "203": 
				return new ResponseEntity<>(advice, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
			case "204": 
				return new ResponseEntity<>(advice, HttpStatus.NO_CONTENT);
			case "205": 
				return new ResponseEntity<>(advice, HttpStatus.RESET_CONTENT);
			case "226":
				return new ResponseEntity<>(advice, HttpStatus.IM_USED);
			case "300":
				return new ResponseEntity<>(advice, HttpStatus.MULTIPLE_CHOICES);
			case "301":
				return new ResponseEntity<>(advice, HttpStatus.MOVED_PERMANENTLY);
			case "302":
				return new ResponseEntity<>(advice, HttpStatus.FOUND);
			case "303":
				return new ResponseEntity<>(advice, HttpStatus.SEE_OTHER);
			case "304":
				return new ResponseEntity<>(advice, HttpStatus.NOT_MODIFIED);
			case "400":
				return new ResponseEntity<>(advice, HttpStatus.BAD_REQUEST);
			case "401":
				return new ResponseEntity<>(advice, HttpStatus.UNAUTHORIZED);
			case "402":
				return new ResponseEntity<>(advice, HttpStatus.PAYMENT_REQUIRED);
			case "403":
				return new ResponseEntity<>(advice, HttpStatus.FORBIDDEN);
			case "404":
				return new ResponseEntity<>(advice, HttpStatus.NOT_FOUND);
			case "405":
				return new ResponseEntity<>(advice, HttpStatus.METHOD_NOT_ALLOWED);
			case "409":
				return new ResponseEntity<>(advice, HttpStatus.CONFLICT);			
			case "417":
				return new ResponseEntity<>(advice, HttpStatus.EXPECTATION_FAILED);
			case "424":
				return new ResponseEntity<>(advice, HttpStatus.FAILED_DEPENDENCY);		
			case "500":
				return new ResponseEntity<>(advice, HttpStatus.INTERNAL_SERVER_ERROR);  
			case "501":
				return new ResponseEntity<>(advice, HttpStatus.NOT_IMPLEMENTED);
			case "502":
				return new ResponseEntity<>(advice, HttpStatus.BAD_GATEWAY);
			case "503":
				return new ResponseEntity<>(advice, HttpStatus.SERVICE_UNAVAILABLE);
			case "504":
				return new ResponseEntity<>(advice, HttpStatus.GATEWAY_TIMEOUT);
			case "505":
				return new ResponseEntity<>(advice, HttpStatus.HTTP_VERSION_NOT_SUPPORTED);			
			default: 
				// this default case always returns a 406 NOT ACCEPTABLE status code
				return new ResponseEntity<Object>("The PROVIDED STATUS CODE must be a number between 100-105, 200-205, 300-304, 400-405, 500-505 and 226,409,417,424", 
							HttpStatus.NOT_ACCEPTABLE);				
		}	    
	}
}
