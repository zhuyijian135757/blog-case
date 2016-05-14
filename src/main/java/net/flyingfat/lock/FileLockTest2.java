package net.flyingfat.lock;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest2 {

	public static void main(String[] args) {

		final FileLockTest2 test=new FileLockTest2();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				test.read();
			}
		}).start();
		
	}
	
	public void read() {
		try{
			File file=new File(this.getClass().getResource("/config.properties").getFile());
			RandomAccessFile rwfile=new RandomAccessFile(file,"r");
			Thread.sleep(1000);
			System.out.println(rwfile.readLine());
			rwfile.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
