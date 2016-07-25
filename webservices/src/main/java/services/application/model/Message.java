package services.application.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {

	private long id;
	private String messaage;
	private Date creationDate;
	private String author;
	
	public Message() {
		// TODO Auto-generated constructor stub
	}
	
	public Message(Long id, String message, String author) {
		
		this.id=id;
		this.messaage=message;
		this.author=author;
		this.creationDate=new Date();
	}
	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	
	public String getMessaage() {
		return messaage;
	}
	public void setMessaage(String messaage) {
		this.messaage = messaage;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}


	
	
}
