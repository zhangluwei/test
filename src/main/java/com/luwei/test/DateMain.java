package com.luwei.test;

import java.lang.reflect.Constructor;

import org.apache.log4j.Logger;

public class DateMain {
	/**
	 * Logger for this class
	 */

	public DateMain(int a) {




	}

	public DateMain(int c, int d) {
		
	}

	private static final Logger logger = Logger.getLogger(DateMain.class);

	public static void main(String[] args) throws Exception {

		Integer z = 0;

		System.out.println(0 == z);

		Class clazz = DateMain.class;

		Constructor[] css = clazz.getConstructors();

		for (Constructor cs : css) {
			System.out.println(cs.getParameterTypes());
		}
	}

}
