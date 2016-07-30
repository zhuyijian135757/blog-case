package net.flyingfat.hash;

import java.util.Date;

public class HashObject {

	private String a;
	
	private int b;
	
	private int c;
	
	private String d;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + b;
		result = prime * result + (int) (c ^ (c >>> 32));
		result = prime * result + ((d == null) ? 0 : d.hashCode());
		return result;
		int a=(int) new Date().getTime();
		System.out.println(a);
		return a;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HashObject other = (HashObject) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (b != other.b)
			return false;
		if (c != other.c)
			return false;
		if (d == null) {
			if (other.d != null)
				return false;
		} else if (!d.equals(other.d))
			return false;
		System.out.println("1111111");
		return true;
	}*/
	
}
