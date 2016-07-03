package net.flyingfat.serialization;

import java.io.Serializable;

public class Object11 extends Super implements Serializable {

	private static final long serialVersionUID = 1L;
	private String acb="abc";
	private int a=123;
	
	public Object11(String s) {
		super(s);
	}
	
	public String getAcb() {
		return acb;
	}
	
	public void setAcb(String acb) {
		this.acb = acb;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
}
