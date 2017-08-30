package com.luwei.spring;

import java.util.Map;

import org.apache.log4j.Logger;

public class SpringTest1 {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SpringTest1.class);

	public SpringTest1(int a,int b) {
		
		if (logger.isInfoEnabled()) {
			logger.info("SpringTest1(int, int) - a=" + a + ", b=" + b);
		}
		
	}
	
	public SpringTest1(Map<String,String> m,int b) {
		if (logger.isInfoEnabled()) {
			logger.info("SpringTest1(Map<String,String>, int) - m=" + m + ", b=" + b);
		}
	}
	
	public static void main(String[] args) {
			
	}
	
	
}
