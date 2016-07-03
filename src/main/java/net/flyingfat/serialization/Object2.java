package net.flyingfat.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Object2  implements Externalizable {
	private static final long serialVersionUID = 1L;
	private String bac="123";
	private int a;

	public String getBac() {
		return bac;
	}

	public void setBac(String bac) {
		this.bac = bac;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.write(bac.getBytes("utf-8"));
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		in.readObject();
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
}
