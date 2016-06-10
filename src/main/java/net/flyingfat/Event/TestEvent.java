package net.flyingfat.Event;

public class TestEvent {

	public static void main(String[] args) {
		
		EventSource source=new EventSource();
		source.addListener(new EventsListener());
		
		source.setName("hi");
		
	}

}
