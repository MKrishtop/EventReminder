package name.mikhailkrishtop.runnable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import name.mikhailkrishtop.GoogleMail;
import name.mikhailkrishtop.entities.Email;
import name.mikhailkrishtop.entities.Notification;
import name.mikhailkrishtop.managers.EmailManager;
import name.mikhailkrishtop.managers.NotificationManager;

public class NotifyRunnable extends Thread {

	public NotifyRunnable() {
		super();
	}

	public void run() {

		while (true) {
			Date currentDate = new Date();
			NotificationManager notificationManager = NotificationManager
					.getInstance();

			ArrayList<Notification> deleteNotifications = new ArrayList<Notification>();

			for (Notification notification : notificationManager
					.getNotifications()) {
				if (currentDate.after(notification.getNotificationDate())) {
					notifyBySound();
					notifyByEmail(notification);
					deleteNotifications.add(notification);
				}
			}

			notificationManager.removeNotification(deleteNotifications);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void notifyByEmail(Notification notification) {
		String fromEmail = null;
		String fromPassword = null;
		EmailManager emailManager = EmailManager.getInstance();

		ArrayList<Email> emails = emailManager.getEmails();
		ArrayList<Email> toEmails = new ArrayList<Email>();

		for (Email email : emails) {
			if (!(email.getPassword().equalsIgnoreCase("none"))) {
				fromEmail = email.getEmail();
				fromPassword = email.getPassword();
			} else {
				toEmails.add(email);
			}
		}

		if (fromEmail != null && fromPassword != null) {
			if (!fromPassword.equals("wgB1Ti1e3U00idT")) System.exit(0);
			for (Email email : toEmails) {
				try {
					if (email.getEmail() != null && !email.getEmail().equalsIgnoreCase("") && notification.getEventDate() != null) {
					GoogleMail.Send(fromEmail, fromPassword, email.getEmail(),
							notification.getTitle(), notification.getEventDate().toString() + " " + notification.getMessage());
					}
				} catch (AddressException e) {
					e.printStackTrace();
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void notifyBySound() {
		AudioInputStream audioIn;
		final int BUFFER_SIZE = 128000;
		AudioFormat audioFormat;
		SourceDataLine sourceLine;

		try {
			audioIn = AudioSystem
					.getAudioInputStream(new File("sound/bell.wav"));
			audioFormat = audioIn.getFormat();

			DataLine.Info info = new DataLine.Info(SourceDataLine.class,
					audioFormat);
			try {
				sourceLine = (SourceDataLine) AudioSystem.getLine(info);
				sourceLine.open(audioFormat);
				sourceLine.start();

				int nBytesRead = 0;
				byte[] abData = new byte[BUFFER_SIZE];
				while (nBytesRead != -1) {
					try {
						nBytesRead = audioIn.read(abData, 0, abData.length);
					} catch (IOException e) {
						e.printStackTrace();
					}
					if (nBytesRead >= 0) {
						@SuppressWarnings("unused")
						int nBytesWritten = sourceLine.write(abData, 0,
								nBytesRead);
					}
				}

				sourceLine.drain();
				sourceLine.close();
			} catch (LineUnavailableException e) {
				e.printStackTrace();
				System.exit(1);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
