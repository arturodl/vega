package com.core.app.otd.xml;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CustomDateTimeFormatter extends XmlAdapter<String, Date>{
	
	private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public String marshal(Date dateFromJava) throws Exception {
		synchronized (formatter) {
            return formatter.format(dateFromJava);
        }
	}

	@Override
	public Date unmarshal(String dateFromXML) throws Exception {
		synchronized (formatter) {
            return formatter.parse(dateFromXML);
        }
	}

}
