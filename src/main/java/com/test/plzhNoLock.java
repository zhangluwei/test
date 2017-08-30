package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
public class plzhNoLock {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(plzhNoLock.class.getName());

	private static int size = 9;
	
	private List<String> units ;
	private List<Integer>  number = new ArrayList<Integer>(); 
	public  Boolean endFlag = false;
	public  Long time ;
	private int cur;
	
//	private final static ReentrantLock rlock = new ReentrantLock();

	public plzhNoLock(int i) {
			cur = i;
	}

	public static void main(String[] args) throws Exception {
		
		
		while (true) {
			for (int i = 0; i < size; i++) {
				final int cur = i;
			new Thread(){
					public void run() {
						plzhNoLock obj = new plzhNoLock(cur);
						obj.execute();
					};
				}.start();
			}
			
			Thread.sleep(1000*60*2);
			
			
		}
	}
	
	public void execute(){
		
		init();
		time = System.currentTimeMillis();
		
		int i = 0;
		while(!endFlag){
				String str = toString(number);
//				logger.info("execute() - number=" + number + ", i=" + i + ", str=" + str); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				try {
					number = plus(number);
				} catch (Exception e) {
				System.out.println("<no args>"+(System.currentTimeMillis()-time)); //$NON-NLS-1$
						endFlag = true;
					}
		} 		
 
	}
	public  void init(){
		units = new ArrayList<String>();
 		char c = 'a';
		for (int i = 0; i < size; i++) {
			units.add(String.valueOf(c));
			c++;
		}
		
		
		size = units.size();
		
		for (int i = 0; i < size; i++) {
			number.add(-1);
		}
//		number.set(0, 0);
		number.set(size-1, cur);
	}
	
	public List<Integer> plus(List<Integer> current){
		
		int i = 0;
		while(true){
//		for (int i = 0; i < size; i++) {
			int n = current.get(i) +1;
			
			if(n >= size){
				current.set(i, 0);
				i ++;
				if(i ==(size - 1)){
					throw new RuntimeException();
				}
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
