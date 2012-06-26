package name.mikhailkrishtop.entities;

import java.text.DateFormat;
import java.util.Date;

public class Notification {
	private String title = "none";
	private String message = "none"; 
	private Date eventDate = new Date();
	private Date notificationDate = new Date();
	
	public Notification(String title, String message, Date eventDate, Date notificationDate) {
		this.title = title;
		this.message = message;
		this.eventDate = eventDate;
		this.notificationDate = notificationDate;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public Date getNotificationDate() {
		return notificationDate;
	}
	public void setNotificationDate(Date notificationDate) {
		this.notificationDate = notificationDate;
	}
	
	public String toString() {
		return "Title: " + title + "; Message: " + message + "; EventDate: " + eventDate + "; NotificationDate: " + notificationDate;
	}
	
	public String toShortString() {
		return " " + DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(eventDate) + "  ---  " + title;
	}
}
