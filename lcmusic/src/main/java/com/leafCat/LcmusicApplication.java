package com.leafCat;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class LcmusicApplication extends SpringBootServletInitializer{
	
	private static Logger logger = Logger.getLogger(LcmusicApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LcmusicApplication.class, args);
		logger.info("========================== Server Sterted ================================");
	}
	
}
