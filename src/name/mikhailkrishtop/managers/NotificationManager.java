package name.mikhailkrishtop.managers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import name.mikhailkrishtop.entities.Notification;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class NotificationManager {

	private static NotificationManager m_instance;
	private ArrayList<Notification> m_notifications = null;
	private static final String DATA_FILEPATH = "data/notifications.xml";

	private NotificationManager() {
	}

	public static synchronized NotificationManager getInstance() {
		if (m_instance == null) {
			m_instance = new NotificationManager();
		}
		return m_instance;
	}

	public ArrayList<Notification> getNotifications() {
		if (m_notifications == null) {
			m_notifications = readNotification(DATA_FILEPATH);
		}

		return m_notifications;
	}
	
	public void addNotification(Notification newNotification) {
		if (m_notifications == null) {
			m_notifications = readNotification(DATA_FILEPATH);
		}
		
		ArrayList<Notification> notifications = new ArrayList<Notification>();
		
		for (Notification notification : m_notifications) {
			if (notification.getEventDate().before(newNotification.getEventDate())) {
				notifications.add(notification);
			}
		}
		
		notifications.add(newNotification);
		
		for (Notification notification : m_notifications) {
			if (notification.getEventDate().after(newNotification.getEventDate())) {
				notifications.add(notification);
			}
		}
		
		setNotifications(notifications);
	}
	
	public void removeNotification(ArrayList<Notification> notifications) {
		if (m_notifications == null) {
			m_notifications = readNotification(DATA_FILEPATH);
		}
		
		m_notifications.removeAll(notifications);
		setNotifications(m_notifications);
	}

	private void setNotifications(ArrayList<Notification> notifications) {
		m_notifications = notifications;

		XStream xStream = new XStream(new DomDriver());
		xStream.alias("notification", Notification.class);
		Random rand = new Random();

		int counter = 0;
		while (counter++ < 20) {
			try {
				xStream.toXML(m_notifications, new FileWriter(DATA_FILEPATH));
				break;
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (counter > 1) {
				try {
					Thread.sleep((long) ((1000 * rand.nextFloat()) + 100), 0);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private ArrayList<Notification> readNotification(String filepath) {
		XStream xStream = new XStream(new DomDriver());
		xStream.alias("notification", Notification.class);
		Random rand = new Random();

		int counter = 0;
		while (counter++ < 20) {
			try {
				return (ArrayList<Notification>) xStream.fromXML(new FileReader(filepath));
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (counter > 1) {
				try {
					Thread.sleep((long) ((1000 * rand.nextFloat()) + 100), 0);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return new ArrayList<Notification>();
	}
}
