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
		new ObjectTest().serialization();
	}
	
	public void serialization() throws Exception{
		URL url=ObjectTest.class.getResource("/config.properties");
		OutputStream output=new FileOutputStream(new File(url.getPath()));
		ObjectOutput objectOut=new ObjectOutputStream(output);
		objectOut.writeObject(new Object1());
		objectOut.close();
		output.close();
		
		/*URL url2=ObjectTest.class.getResource("/config2.properties");
		OutputStream output2=new FileOutputStream(new File(url2.getPath()));
		ObjectOutput objectOut2=new ObjectOutputStream(output2);
		objectOut2.writeObject(new Object2());
		objectOut2.close();
		objectOut2.close();*/
	}
}
