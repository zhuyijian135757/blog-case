package net.flyingfat.lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class ReenLock {

	ReentrantLock lock=new ReentrantLock();
	Condition condition=lock.newCondition();
	
	public static void main(String[] args) {

		Thread.currentThread().setName("main");
		final ReenLock test4=new ReenLock();
		
		new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(1000);
					test4.run();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"sub").start();
		
		test4.run();
		
	}
	
	public void run(){
		try{
			lock.lock();
			System.out.println("Thread: "+Thread.currentThread().getName()+" get lock");
			if(Thread.currentThread().getName().equals("main")){
				System.out.println("main thread block, release object lock");
				condition.await(); //main线程执行到这会一直阻塞，并且释放对象锁，让sub线程能够进入该方法
				System.out.println("main thread is signaled，get object lock again");
			}
			if(Thread.currentThread().getName().equals("sub")){
				condition.signal(); //sub线程得到main线程释放的对象锁，  唤醒阻塞的main线程使其往下执行
				System.out.println("sub thread signal");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			lock.unlock();
			System.out.println("Thread: "+Thread.currentThread().getName()+" release lock");

		}
	}
 
}
