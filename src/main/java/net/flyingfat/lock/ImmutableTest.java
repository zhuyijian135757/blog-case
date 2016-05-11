package net.flyingfat.lock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableTest {

	public static void main(String[] args) {

		ImmutableTest immutableTest=new ImmutableTest();
		
		List<String> list=new ArrayList<String>();
		list.add("a");
		list.add("b");
		BestAddressBook book=immutableTest.new BestAddressBook(list);
		list.add("c");
		
		for(Object s :book.getNames()){
			System.out.println(s);
		}
		
		book.getNames().add("d");
		
	}
	
	
	public class BestAddressBook {
		private final List names;
		@SuppressWarnings("unchecked")
		public BestAddressBook(List names) {
			this.names = Collections.unmodifiableList(names);
		}
		public List getNames() {
			return names;
		}
	}
	

}
