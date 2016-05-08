package net.flyingfat.lock;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class ReenLock2 {

	ReentrantLock lock=new ReentrantLock();
	Condition condition1=lock.newCondition();
	
	public static void main(String[] args)  {
		final ReenLock2 reenLock2=new ReenLock2();
		Thread t=new Thread(new Runnable() {
			public void run() {
				reenLock2.run1();
			}
		});
		t.start();
		
		Thread t1=new Thread(new Runnable() {
			public void run() {
				reenLock2.run1();
			}
		});
		t1.start();
		
		try {
			Thread.sleep(1000);
			t1.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		try{
			lock.lockInterruptibly(); //可中断锁
			System.out.println("thread："+Thread.currentThread().getName()+" get lock");
			Thread.sleep(4000);
			System.out.println("thread："+Thread.currentThread().getName()+" wake up");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("thread："+Thread.currentThread().getName()+" release lock");
			lock.unlock();
		}
	}
	
	
	public void run1(){
		try{
			lock.lock();  //ReentrantLock实现的常规锁
			System.out.println("thread："+Thread.currentThread().getName()+" get lock");
			Thread.sleep(4000);
			System.out.println("thread："+Thread.currentThread().getName()+" wake up");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("thread："+Thread.currentThread().getName()+" release lock");
			lock.unlock();
		}
	}
	
	
	public synchronized void run2(){  //synchronized 实现的常规锁
		try {
			System.out.println("thread："+Thread.currentThread().getName()+" get lock");
			Thread.sleep(4000);
			System.out.println("thread："+Thread.currentThread().getName()+" release lock");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	

	public void run3(){
		try{
			lock.tryLock(5,TimeUnit.SECONDS); //
			System.out.println("thread："+Thread.currentThread().getName()+" get lock");
			Thread.sleep(4000);
			System.out.println("thread："+Thread.currentThread().getName()+" wake up");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			System.out.println("thread："+Thread.currentThread().getName()+" release lock");
			lock.unlock();
		}
   }

}
