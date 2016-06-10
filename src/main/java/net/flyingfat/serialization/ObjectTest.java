package net.flyingfat.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URL;

public class ObjectTest {

	public static void main(String[] args) throws Exception {

		//new ObjectTest().output();
		
		new ObjectTest().input();

	}
	
	public void output() throws Exception{
		URL url=ObjectTest.class.getResource("/config.properties");
		OutputStream output=new FileOutputStream(new File(url.getPath()));
		ObjectOutput objectOut=new ObjectOutputStream(output);
		objectOut.writeObject(new Object1());
		objectOut.close();
		output.close();
	}
	
	public void input() throws Exception{
		URL url=ObjectTest.class.getResource("/config.properties");
		InputStream input=new FileInputStream(new File(url.getPath()));
		ObjectInput objectIn=new ObjectInputStream(input);
		Object1 object1=(Object1) objectIn.readObject();
		objectIn.close();
		input.close();
	}
	
}
