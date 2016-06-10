package net.flyingfat.Event;

import java.util.ArrayList;
import java.util.List;

public class EventSource {

	private String name;
	
	private List<EventsListener> list;
	
	public EventSource(){
		list=new ArrayList<EventsListener>();
	}
	
	public void addListener(EventsListener listener){
		list.add(listener);
	}
	
	public void notifies(){
		for(EventsListener eventsListener: list){
			eventsListener.fireEvent(new Event("event"));
		}
	}

	public void setName(String name) {
		this.name = name;
		notifies();
	}
	
	
}
