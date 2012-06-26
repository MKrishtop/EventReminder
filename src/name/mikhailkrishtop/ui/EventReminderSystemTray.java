package name.mikhailkrishtop.ui;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import name.mikhailkrishtop.runnable.NotifyRunnable;

public class EventReminderSystemTray {
	
	static Thread notificationThread = new NotifyRunnable();
	
	public static void main(String[] args) {
		notificationThread.start();

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager
							.setLookAndFeel("org.pushingpixels.substance.api.skin.SubstanceModerateLookAndFeel");
				} catch (UnsupportedLookAndFeelException ex) {
					ex.printStackTrace();
				} catch (IllegalAccessException ex) {
					ex.printStackTrace();
				} catch (InstantiationException ex) {
					ex.printStackTrace();
				} catch (ClassNotFoundException ex) {
					ex.printStackTrace();
				}
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		final PopupMenu popup = new PopupMenu();
		final TrayIcon trayIcon = new TrayIcon((new ImageIcon("icons/bell.png",
				"EventReminder")).getImage());
		final SystemTray tray = SystemTray.getSystemTray();

		MenuItem aboutItem = new MenuItem("About");
		MenuItem exitItem = new MenuItem("Exit");
		popup.add(aboutItem);
		popup.add(exitItem);
		trayIcon.setPopupMenu(popup);

		try {
			tray.add(trayIcon);
		} catch (AWTException e) {
			System.out.println("TrayIcon could not be added.");
			return;
		}

		trayIcon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventReminder eventReminder = new EventReminder();
				eventReminder.getFrame().setVisible(true);
			}
		});

		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int answer = JOptionPane.showConfirmDialog(null, "Do you realy want to exit EventReminder?", "Confirmation dialog", JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION) {
					tray.remove(trayIcon);
					System.exit(0);
				}
			}
		});
		
		aboutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "EventReminder v1 \n Mikhail Krishtop \n mikhailkrishtop@gmail.com");
			}
		});
	}
}
