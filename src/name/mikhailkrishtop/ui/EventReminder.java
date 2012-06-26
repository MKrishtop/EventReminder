package name.mikhailkrishtop.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import name.mikhailkrishtop.entities.Notification;
import name.mikhailkrishtop.managers.NotificationManager;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class EventReminder {

	private JFrame frame;
	
	AddEventForm addEventForm = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventReminder window = new EventReminder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EventReminder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 433, 303);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(
				new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("1dlu"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(19dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("top:max(122dlu;default):grow"),}));

		JButton button = new JButton("");
		button.setIcon(new ImageIcon(
				"icons/add.png"));
		button.setFocusable(false);
		frame.getContentPane().add(button, "2, 2");

		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(
				"icons/delete.png"));
		button_1.setFocusable(false);
		frame.getContentPane().add(button_1, "4, 2");

		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(
				"icons/email.png"));
		button_2.setFocusable(false);
		frame.getContentPane().add(button_2, "8, 2");

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Future events",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel, "2, 4, 7, 1, fill, fill");
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("1dlu"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("1dlu"),},
			new RowSpec[] {
				RowSpec.decode("top:max(122dlu;default):grow"),}));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane, "3, 1, fill, fill");

		DefaultListModel listModel = new DefaultListModel();
	
		NotificationManager notificationManager = NotificationManager.getInstance();
		ArrayList<Notification> notifications = notificationManager.getNotifications();
		for (Notification notification : notifications) {
			listModel.add(notifications.indexOf(notification), notification.toShortString());
		}
		
		final JList list = new JList(listModel);
		scrollPane.setViewportView(list);
//
//		DefaultListModel listModel = new DefaultListModel();
//		listModel.addElement("31.08.2012 | Feed the dog | I must to feed the dog because he is hungry");

		list.setModel(listModel);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addEventForm = new AddEventForm(list);
				addEventForm.getFrame().addWindowStateListener(new WindowAdapter() {
				    @Override
				    public void windowStateChanged(final WindowEvent event) {
				    	
				    }
				});
				addEventForm.getFrame().setVisible(true);
			}
		});
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NotificationManager notificationManager = NotificationManager.getInstance();
				
				ArrayList<Notification> notifications = notificationManager.getNotifications();
				
				ArrayList<Notification> deleteNotifications = new ArrayList<Notification>();
				
				for (Integer i : list.getSelectedIndices()) {
					deleteNotifications.add(notifications.get(i));
				}
				
				notificationManager.removeNotification(deleteNotifications);
				
				DefaultListModel innerListModel = new DefaultListModel();
		    	
				notifications = notificationManager.getNotifications();
				
				for (Notification notification : notifications) {
					innerListModel.add(notifications.indexOf(notification), notification.toShortString());
				}
				list.setModel(innerListModel);
				list.repaint();
			}
		});
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmailsForm emailsForm = new EmailsForm();
				emailsForm.getFrame().setVisible(true);
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}
}
