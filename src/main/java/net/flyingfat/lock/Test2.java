package net.flyingfat.lock;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test2 {
	
	
	

	public static void main(String[] args) throws Exception {
		
		//ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
		//lock.readLock().lock();
		//String a="abc";
		//System.out.println(a);
		//System.out.println(a.toUpperCase()==a);
		//FileChannel fileChannel=input.getChannel();
		//fileChannel.read(ByteBuffer.allocate(1024));
		//FileInputStream file=new FileInputStream(new File());
		//write();
		
	}
	
	

	
	public static void write() throws Exception{
		FileOutputStream output=new FileOutputStream("E:\\git\\blog-case\\blog-case\\src\\main\\resources\\config.properties");
		for(int i=0;i<100000;i++){
			output.write(i);
			Thread.sleep(100);
		}
	}

}
