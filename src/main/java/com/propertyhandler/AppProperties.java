package com.propertyhandler;

/*
 * @Author: Shrikrishna Prabhumirashi
 * Date Created: 12-Jun-2018
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class AppProperties {
	private static final String PROPERTIES_FILE_LOCATION = "user.home";
	private static final String PROPERTIES_FILE_NAME = "common.properties";
    
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    
	private static final Logger LOGGER = Logger.getLogger(AppProperties.class.getName());
    
    public static final void setProperty(String name, String value) {

        Properties properties = loadProperties();

        if (value != null && !value.isEmpty()) {

            properties.setProperty(name, value);

            saveProperties(properties);
        }
    }

    /**
     * @param name
     * @return
     */
    public static final String getProperty(String name) {

        Properties properties = loadProperties();

        return properties.getProperty(name);
    }

    /**
     * @param name
     * @return
     */
    public static final Map<String,String> getAllProperties() {

        Properties properties = loadProperties();
        
        Map<String, String> retValues = new HashMap<>();
        
        properties.forEach( (k, v) -> retValues.put(k.toString(),  v.toString()));
        
        return retValues;
    }
    
    /**
     * Reset all properties.
     */
    public static final void resetAllProperties() {

        Properties properties = loadProperties();

        properties.clear();

        saveProperties(properties);
    }

    private static String getPropertyFilePath() {
    	return System.getProperty(PROPERTIES_FILE_LOCATION) + File.separator + PROPERTIES_FILE_NAME;
    }
    
    private static boolean propertyFileExists() {
    	return new File(getPropertyFilePath()).exists();
    }
    
    /**
     * @return
     */
    private static Properties loadProperties() {

        Properties properties = new Properties();
        
        if(!propertyFileExists()) {
        	return properties;
        }
        
        try (FileReader reader = new FileReader(getPropertyFilePath())) {

            properties.load(reader);

            return properties;

        } catch (IOException e) {

            throw new AppPropertiesException(e.getMessage(), e);
        }
    }


    /**
     * @param properties
     */
    private static void saveProperties(Properties properties) {

        try (FileWriter writer = new FileWriter(System.getProperty(PROPERTIES_FILE_LOCATION) + File.separator + PROPERTIES_FILE_NAME)) {

            properties.store(writer, String.format("Last update %s", DATE_FORMAT.format(new Date())));

        } catch (IOException e) {

            throw new AppPropertiesException(e.getMessage(), e);
        }
    }

}
