package net.flyingfat.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {
	
	private ProxyObject pOject;

	public ProxyHandler(ProxyObject pOject) {
		super();
		this.pOject = pOject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("before proxy");
		Object object=method.invoke(pOject, args);
		System.out.println("after proxy");
		return object;
	}


}
