package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

public class plzh {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(plzh.class);
	
	private static int size = 3;
	
	private static List<String> units ;
	private static List<Integer>  number = new ArrayList<Integer>(); 
	
	public final static Object lock = new  Object();
	
	public  Boolean endFlag = false;
	
	public static Long time ;
	
	private int cur;
	
//	private final static ReentrantLock rlock = new ReentrantLock();

	public static void main(String[] args) {
		init();
		time = System.currentTimeMillis();
		for (int i = 0; i < 1; i++) {
			new Thread(){
				public void run() {
					plzh obj = new plzh();
						obj.execute();					 
				};
			}.start();
		}
	}
	
	public void execute(){
		int i = 0;
		while(!endFlag){
//		 for (int i = 0; i < 12; i++) {
		
				String str = toString(number);
//				logger.info("execute() - number=" + number + ", i=" + i + ", str=" + str); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
//				synchronized (lock) {
//					number = plus(number);
//				}
//				rlock.lock();
				try {
					number = plus(number);
				} catch (Exception e) {
					synchronized (lock) {
						if(!endFlag){
							System.out.println("cost :" + (System.currentTimeMillis() - time));
						}
						endFlag = true;
					}
					
				} 		
//				rlock.unlock();
			}
	}
	public static void init(){
		units = new ArrayList<String>();
//		units.add("a");
//		units.add("b");
//		units.add("c");
		
		char c = 'a';
		for (int i = 0; i < 8; i++) {
			units.add(String.valueOf(c));
			c++;
		}
		
		
		size = units.size();
		
		for (int i = 0; i < size; i++) {
			number.add(-1);
		}

		number.set(0, 0);
		
	}
	
	public List<Integer> plus(List<Integer> current){
		
		int i = 0;
		while(true){
//		for (int i = 0; i < size; i++) {
			int n = current.get(i) +1;
			
			if(n >= size){
				current.set(i, 0);
				i ++;
				continue;
			}
			
			current.set(i, n);
			break;
								
		}

//		logger.info("plus(List<Integer>) - current=" + current); //$NON-NLS-1$

		return current;
		
	}
	
	public String toString(List<Integer> current){
		
		StringBuilder builder = new StringBuilder();
		for (Integer i : current) {
			if(i > -1)
			builder.append(units.get(i));
		}
		
		return builder.toString();
		
	}

}
