package net.flyingfat.hash;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashTest {

	public static void main(String[] args) {
		
		Set<String> set=new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("c");
		
		Iterator<String> it=set.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
		/*HashObject object=new HashObject();
		object.setA("a");
		object.hashCode();*/
		
		HashObject object=new HashObject();
		HashObject object2=new HashObject();
		System.out.println(object.equals(object2));
		
	}

}
