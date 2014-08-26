package com.ceiroa.ihealthmaven.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesHandler {

    Properties props = new Properties();

    public PropertiesHandler() {
        try {
            InputStream is = getClass().getResourceAsStream( "/application.properties");
            props.load(is);
        } catch (IOException ex) {
            Logger.getLogger(PropertiesHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getProperty(String property) {
        return props.getProperty(property);
    }
}
