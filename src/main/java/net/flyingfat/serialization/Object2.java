package net.flyingfat.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public class Object2 implements Externalizable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bac;

	public String getBac() {
		return bac;
	}

	public void setBac(String bac) {
		this.bac = bac;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		
	}
	
}
