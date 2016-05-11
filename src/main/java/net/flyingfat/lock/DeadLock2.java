package net.flyingfat.lock;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLock2 {
	public static void main(String[] args) {
		final DeadLock2 deadLock2=new DeadLock2();
		final ReentrantLock lock1=new ReentrantLock();
		final ReentrantLock lock2=new ReentrantLock();
		new Thread(new Runnable() {
			public void run() {
				try {
					deadLock2.run(lock1,lock2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				try {
					deadLock2.run(lock2,lock1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
    public void run(ReentrantLock lockA,ReentrantLock lockB) throws Exception{
    	try{
    		lockA.lock();
			try{
				Thread.sleep(1000);
	    		lockB.lock();
			}catch(Exception e){
	    		e.printStackTrace();
	    	}finally{
	    		lockB.unlock();
	    	}
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		lockA.unlock();
    	}
    }	

}
