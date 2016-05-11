package net.flyingfat.lock;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchTest {

	public static CountDownLatch latch=new CountDownLatch(10);
	
	public static void main(String[] args){
		CountdownLatchTest test=new CountdownLatchTest();
		for(int i=0;i<20;i++){
			test.new Mythread(latch).start();
		}
		
		try {
			System.out.println("await start");
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			System.out.println("await end");
		}
	}
	
	
    class Mythread extends Thread{
    	
    	private CountDownLatch latch;
    	
    	public Mythread(CountDownLatch latch) {
			super();
			this.latch = latch;
		}

		@Override
    	public void run() {
			try{
				System.out.println(Thread.currentThread());
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				latch.countDown();
			}
    	}

		public CountDownLatch getLatch() {
			return latch;
		}

		public void setLatch(CountDownLatch latch) {
			this.latch = latch;
		}
    	
    }
	
	
}
