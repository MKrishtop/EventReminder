package name.mikhailkrishtop.tests;

import java.util.ArrayList;
import java.util.Date;

import name.mikhailkrishtop.entities.Notification;
import name.mikhailkrishtop.managers.NotificationManager;

public class NotificationManagerTest {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NotificationManager notificationManager = NotificationManager.getInstance();
		
		notificationManager.addNotification(new Notification("qwe","rty",new Date(), new Date()));
		notificationManager.addNotification(new Notification("asd","sdf",new Date(), new Date()));
		notificationManager.addNotification(new Notification("456","234",new Date(), new Date()));
		notificationManager.addNotification(new Notification("cvb","rty",new Date(), new Date()));
		
		ArrayList<Notification> notifications1 = notificationManager.getNotifications();
		
		for (Notification notification : notifications1) {
			System.out.println(notification);
		}
		
		System.out.println();

		notificationManager.removeNotification(notifications1);
		
		for (Notification notification : notifications1) {
			System.out.println(notification);
		}
		
		System.out.println("NotificationManagerTest done.");
	}
}
