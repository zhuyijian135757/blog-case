package net.flyingfat.Event;

import java.util.EventListener;

public class EventsListener implements EventListener {

	public void fireEvent(Event event){
		System.out.println("fire event:"+event.getSource());
	}
	
}
