package net.flyingfat.lock;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {

	public static void main(String[] args) {

		final FileLockTest test=new FileLockTest();
		new Thread(new Runnable() {
			@Override
			public void run() {
				test.rw();
			}
		}).start();
		
	}

	
	public void rw() {
		try{
			File file=new File(this.getClass().getResource("/config.properties").getFile());
			RandomAccessFile rwfile=new RandomAccessFile(file,"rw");
			FileChannel fileChannel=rwfile.getChannel();
			FileLock fileLock=fileChannel.lock();
			fileChannel.write(ByteBuffer.wrap("hirw".getBytes()));
			Thread.sleep(10000);
			fileLock.release();
			fileChannel.close();
			rwfile.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
