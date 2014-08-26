package com.ceiroa.ihealthmaven.model;

public class PropsHandlerFactory {

    private static PropertiesHandler propHandler;

    public static PropertiesHandler getHandler() {
        if(propHandler == null) 
            propHandler = new PropertiesHandler();
        return propHandler;
    }
}
