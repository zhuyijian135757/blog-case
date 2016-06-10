package net.flyingfat.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test {
	
	
	

	public static void main(String[] args) {
		
		//ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
		//lock.readLock().lock();
		String a="abc";
		
		System.out.println(a);
		System.out.println(a.toUpperCase()==a);
		
	}

}
