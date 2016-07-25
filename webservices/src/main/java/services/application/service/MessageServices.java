package services.application.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import services.application.model.Message;

public class MessageServices {
	private static Map<Long, Message> messages=new HashMap<Long, Message>();

	public MessageServices() {
	}
	public List<Message> getAllMessgaes() {
		
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessgaesForYear(int year) {
		
		 List<Message> messagesForYear = new ArrayList<Message>();
		Calendar calendar=Calendar.getInstance();
		
		for(Message message:messages.values()) {
			calendar.setTime(message.getCreationDate());
			if(calendar.get(Calendar.YEAR) ==year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesInRange(int start, int end) {
		
		List<Message> list=new ArrayList<Message>(messages.values());
		if(start+ end == messages.size()) return new ArrayList<Message>();
		return list.subList(start, start+end);
		
	}
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
		
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	
	public Message updateMessage(Message message) {
		if(message.getId() <=0) {
			return null;
		}
		
		messages.put(message.getId(), message);
		return message;
	}
	
	public void deleteMessage(long id) {
		messages.remove(id);
	}
}
