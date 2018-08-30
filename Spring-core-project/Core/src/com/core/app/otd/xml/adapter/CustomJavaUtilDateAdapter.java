package com.core.app.otd.xml.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CustomJavaUtilDateAdapter extends XmlAdapter<String, Date>{
	
	private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public String marshal(Date dateFromJava) throws Exception {
		synchronized (formatter) {
            return formatter.format(dateFromJava);
        }
	}

	@Override
	public Date unmarshal(String dateFromXML) throws Exception {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Trying to unmarshal: "+dateFromXML);
		synchronized (formatter) {
            return formatter.parse(dateFromXML);
        }
	}

}
