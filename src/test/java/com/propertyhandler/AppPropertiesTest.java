package com.propertyhandler;

/*
 * @Author: Shrikrishna Prabhumirashi
 * Date Created: 12-Jun-2018
 * */

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

public class AppPropertiesTest {
	public static Logger LOGGER = Logger.getLogger(AppPropertiesTest.class.getName());
	
	@Test
	public void propertiesTest() {
		String propName = "Test Key";
		String propValue = "Test Value";
		
		AppProperties.resetAllProperties();
		
		AppProperties.setProperty(propName, propValue);
		
		LOGGER.info(String.format("Property '%s' value is '%s'",propName, AppProperties.getProperty(propName)) );
		
		Assert.assertTrue(AppProperties.getProperty(propName).equals(propValue));	
	}
}
