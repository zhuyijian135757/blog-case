package net.flyingfat.serialization;

import java.io.Serializable;

public class Object1 extends Super implements Serializable {
	private static final long serialVersionUID = 1L;
	private String bac="abc";
	private int a=123;
	
	public String getBac() {
		return bac;
	}

	public void setBac(String bac) {
		this.bac = bac;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
}

