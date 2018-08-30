package com.core.app.otd.xml.adapter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CustomLocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime>{
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public LocalDateTime unmarshal(String stringLocalDateTime) throws Exception {
        return LocalDateTime.parse(stringLocalDateTime);
    }

    public String marshal(LocalDateTime localDateTime) throws Exception {
        //return localDateTime.toString();
    	return localDateTime.format(formatter);
    }

}
