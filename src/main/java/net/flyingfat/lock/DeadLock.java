package net.flyingfat.lock;

public class DeadLock {

	private String lockA="A";
	
	private String lockB="B";
	
	public static void main(String[] args) {
		
		final DeadLock deadLock=new DeadLock();

		new Thread(new Runnable() {
			public void run() {
				try {
					deadLock.run1();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		
		new Thread(new Runnable() {
			public void run() {
				try {
					deadLock.run2();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		
	}
	
    public void run1() throws Exception{
    	
    	synchronized (lockA) {
    		Thread.sleep(1000);
    		System.out.println("run1 get lockA");
    		synchronized (lockB) {
    			System.out.println("run1 get lockB");
    		}
		}
    }	
    
    public void run2() throws Exception{
    	
    	synchronized (lockB) {
    		Thread.sleep(1000);
    		System.out.println("run2 get lockB");
        	synchronized (lockA) {
        		System.out.println("run2 get lockA");
    		}
		}
    	
    }	

}
