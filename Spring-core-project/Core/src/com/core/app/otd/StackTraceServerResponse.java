package com.core.app.otd;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.springframework.http.HttpStatus;

import com.core.app.otd.xml.adapter.CustomLocalDateTimeAdapter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@XmlRootElement(name="StackTraceServerResponse")
@XmlType(propOrder={ "statusName", "statusCode", "requestDate", "message", "debugMessage" })
@XmlAccessorType(XmlAccessType.PROPERTY)
@JsonPropertyOrder({ "messageFromServer", "statusCode", "requestDate", "message", "debugMessage" })
public class StackTraceServerResponse {
	
	@JsonIgnore	
	private HttpStatus httpStatus;
	@JsonProperty("messageFromServer")
	private String statusName;
	private String statusCode;	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime requestDate;
	private String message;
	private String debugMessage;
	//private List<ApiSubError> subErrors;

    private StackTraceServerResponse() {
       requestDate = LocalDateTime.now();
    }

    public StackTraceServerResponse(HttpStatus httpStatus) {
       this();
       this.httpStatus = httpStatus;  
       this.statusCode = String.valueOf(httpStatus.value());
       this.statusName = httpStatus.getReasonPhrase();
    }

    public StackTraceServerResponse(HttpStatus httpStatus, Throwable ex) {
       this(httpStatus);
       this.message = "Unexpected error";
       this.debugMessage = ex.getLocalizedMessage();
    }

    public StackTraceServerResponse(HttpStatus httpStatus, String message, Throwable ex) {
       this(httpStatus);
       this.message = message;
       this.debugMessage = ex.getLocalizedMessage();
    }
    
    @XmlTransient
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
    
    @XmlElement(name="messageFromServer")
	public String getStatusName() {
		return statusName;
	}
    
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	@XmlJavaTypeAdapter(CustomLocalDateTimeAdapter.class)
	public LocalDateTime getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(LocalDateTime requestDate) {
		this.requestDate = requestDate;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	

	public String getDebugMessage() {
		return debugMessage;
	}

	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}	
    
}