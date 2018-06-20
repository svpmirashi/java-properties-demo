package com.wkfsfrc.fscframework.common;

/*
 * @Author: Shrikrishna Prabhumirashi
 * Date Created: 12-Jun-2018
 * */

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.wkfsfrc.fscframework.common.FsFrameworkProperties;

public class FsFrameworkPropertiesTest {
	public static Logger LOGGER = Logger.getLogger(FsFrameworkPropertiesTest.class.getName());
	
	@Test
	public void propertiesTest() {
		String propName = "Test Key";
		String propValue = "Test Value";
		
		FsFrameworkProperties.resetAllProperties();
		
		FsFrameworkProperties.setProperty(propName, propValue);
		
		LOGGER.info(String.format("Property '%s' value is '%s'",propName, FsFrameworkProperties.getProperty(propName)) );
		
		Assert.assertTrue(FsFrameworkProperties.getProperty(propName).equals(propValue));	
	}
}
