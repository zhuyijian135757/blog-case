package net.flyingfat.Proxy;

public class ProxyObject implements ProxyInterFace {

	@Override
	public void testProxy(String args) {
		System.out.println(args);
	}

	@Override
	public void testProxy2(String args) {
		System.out.println(args);
	}

}
