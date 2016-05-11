package net.flyingfat.lock;

public class MyThread {
	
	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			public void run() {
				System.out.println("start");
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				System.out.println("run");
			}
		}).run();
		
	}

}
