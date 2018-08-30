package com.core.app.otd.xml.validation;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import org.springframework.http.converter.HttpMessageNotReadableException;

public class CustomEventHandler implements ValidationEventHandler {

    @Override
    public boolean handleEvent(ValidationEvent event) {

        String message = event.getMessage();
        String linkedMessage = "";
        Throwable throwable = null;
        if(event.getLinkedException() != null) {
            linkedMessage = event.getLinkedException().toString();
            throwable = event.getLinkedException().getCause();
        }
        
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> Message from Event: " + message);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>> Throwable from Event: " + throwable);
        
        boolean ignoreValidationEvent = true;            
        if(message.contains("NumberFormatException") || message.contains("ParseException") || 
           linkedMessage.contains("NumberFormatException") || linkedMessage.contains("AccessorException") ||
           !message.isEmpty() || !linkedMessage.isEmpty()
           ){
            ignoreValidationEvent = false;
        }

        if(ignoreValidationEvent){
            return true;
        }else{
            String nodeName = "";
            if(event.getLocator() != null && event.getLocator().getNode() != null)
                nodeName = event.getLocator().getNode().getNodeName();

            //This is the important line
            //throw new RuntimeException("Error parsing '" + nodeName + "': " + event.getMessage());  
            throw new HttpMessageNotReadableException("Error parsing '" + nodeName + "': " + event.getMessage());          

        }
    }

}
