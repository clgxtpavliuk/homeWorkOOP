package com.test;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class App 
{
    final static Logger logger = LogManager.getLogger(App.class);
	
    public static void main( String[] args )
    {
	logger.info("This is info");
	logger.warn("This is warn");
	logger.error("This is error");
	logger.fatal("This is fatal");
    }
}
