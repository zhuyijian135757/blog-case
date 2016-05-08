package net.flyingfat.lock;


public class SyncLock {
	
	public static void main(String args[]){
		
		final SyncLock lock=new SyncLock();
		Thread.currentThread().setName("main");
		new Thread(new Runnable() {
			public void run() {
				Thread.currentThread().setName("sub");
				try {
					Thread.sleep(1000);
					lock.run2();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		lock.run2();
	}
	
	public synchronized void run2()  {
		try{
			System.out.println("thread "+Thread.currentThread().getName()+" : get object lock ");
			if(Thread.currentThread().getName().equals("main")){
				System.out.println("main thread block, release object lock");
				this.wait(); //main线程执行到这会一直阻塞，并且释放对象锁，让sub线程能够进入该方法
				System.out.println("main thread is notifyed，get object lock again");
			}else if(Thread.currentThread().getName().equals("sub")){
				this.notify(); //sub线程得到main线程释放的对象锁，  唤醒阻塞的main线程使其往下执行
				System.out.println("sub thread notify");
			}
			System.out.println(Thread.currentThread().getName()+" : execute over，release object lock ");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public synchronized void run3() {
		try{
			System.out.println("thread "+Thread.currentThread().getName()+" : get object lock ");
			if(Thread.currentThread().getName().equals("main")){
				this.wait();
				System.out.println("main thread block, release object lock");
			}else if(Thread.currentThread().getName().equals("sub")){
				this.notify();
				System.out.println("sub thread notify, release object lock");
			}
			System.out.println(Thread.currentThread().getName()+" : execute over ");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
