package net.flyingfat.Proxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args) throws SecurityException, ClassNotFoundException {
		
		ProxyHandler handler=new ProxyHandler(new ProxyObject());
		ProxyInterFace inter=(ProxyInterFace) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{ProxyInterFace.class},handler);
		/*for(Method m : inter.getClass().getMethods()){
			System.out.println(m.getName());
			if(m.isAnnotationPresent(Biz.class)){
				System.out.println("biz:"+m.getName());
			}
		};*/
		inter.testProxy("a");
		
		/*Class<?> class2=Class.forName("net.flyingfat.Proxy.ProxyInterFace");
		for(Method method : class2.getMethods()){
			System.out.println(method.getName()+":"+method.isAnnotationPresent(Biz.class));
			
		};*/
		
		
	}

}
