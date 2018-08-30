package com.primefacesmc.beans.aplicacion.controllers.advisor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.core.app.otd.StackTraceServerResponse;
import com.sun.el.parser.ParseException;
import com.sun.xml.bind.api.AccessorException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler
{
	 
	@ExceptionHandler(value= { ParseException.class, AccessorException.class, RuntimeException.class })
	protected ResponseEntity<Object> handleParseException(
	           Exception exception, WebRequest request ) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>> Entering the handleParseException");
		
		StackTraceServerResponse stackTraceServerResponse = new StackTraceServerResponse(HttpStatus.BAD_REQUEST, exception);
		ResponseEntity<Object> responseEntity = buildResponseEntity(stackTraceServerResponse, request);
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>> Exiting the handleParseException");
	    return responseEntity;
	}
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleAllExceptions(
	           Exception exception, WebRequest request) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>> Entering the handleAllExceptions");
		StackTraceServerResponse stackTraceServerResponse = new StackTraceServerResponse(HttpStatus.INTERNAL_SERVER_ERROR, exception);
		ResponseEntity<Object> responseEntity = buildResponseEntity(stackTraceServerResponse, request);
		System.out.println(">>>>>>>>>>>>>>>>>>>>> Exiting the handleAllExceptions");
	    return responseEntity;
	}
	
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, 
							HttpHeaders headers, HttpStatus status, WebRequest request){
		System.out.println(">>>>>>>>>>>>>>>>>>>>> Entering the mediaTypeNotSupported Method ");
		StackTraceServerResponse stackTraceServerResponse = new StackTraceServerResponse(status, ex);
		ResponseEntity<Object> responseEntity = buildResponseEntity(stackTraceServerResponse, request);
		System.out.println(">>>>>>>>>>>>>>>>>>>>> Exiting the mediaTypeNotSupported Method");
		return responseEntity;
	}
	
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, 
			   HttpHeaders headers, HttpStatus status, WebRequest request){
		System.out.println(">>>>>>>>>>>>>>>>>>>>> Entering the mediaTypeNotAcceptable Method ");
		StackTraceServerResponse stackTraceServerResponse = new StackTraceServerResponse(status, ex);
		ResponseEntity<Object> responseEntity = buildResponseEntity(stackTraceServerResponse, request);
		System.out.println(">>>>>>>>>>>>>>>>>>>>> Exiting the mediaTypeNotAcceptable Method");
		return responseEntity;
	}
	
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, 
			HttpHeaders headers, HttpStatus status, WebRequest request){
		System.out.println(">>>>>>>>>>>>>>>>>>>>> Entering the mediaTypeNotAcceptable Method ");
		StackTraceServerResponse stackTraceServerResponse = new StackTraceServerResponse(status, ex);
		ResponseEntity<Object> responseEntity = buildResponseEntity(stackTraceServerResponse, request);
		System.out.println(">>>>>>>>>>>>>>>>>>>>> Exiting the mediaTypeNotAcceptable Method");
		return responseEntity;
	}
	
	private ResponseEntity<Object> buildResponseEntity(StackTraceServerResponse errorDetailsResponse, WebRequest request) {		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Content Type: " +request.getHeader("Content-Type"));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Accepted Type: " +request.getHeader("Accept"));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", request.getHeader("Accept"));
	    return new ResponseEntity<>(errorDetailsResponse, headers, errorDetailsResponse.getHttpStatus());
	}
	
}