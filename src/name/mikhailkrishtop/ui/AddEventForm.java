package name.mikhailkrishtop.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerDateModel;

import name.mikhailkrishtop.entities.Notification;
import name.mikhailkrishtop.managers.NotificationManager;
import net.sourceforge.jdatepicker.DateModel;
import net.sourceforge.jdatepicker.JDateComponentFactory;
import net.sourceforge.jdatepicker.JDatePicker;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class AddEventForm {

	private JFrame frame;
	private JTextField textField;
	private JButton btnNewButton = null;

	JList list;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEventForm window = new AddEventForm();
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
	public AddEventForm() {
		initialize();
	}

	public AddEventForm(final JList list) {
		initialize();
		this.list = list;
//		if (btnNewButton != null) {
//			btnNewButton.addActionListener( new ActionListener() {
//
//				@Override
//				public void actionPerformed(ActionEvent paramActionEvent) {
//
//					
//				}
//			});
//		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(150, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("1dlu"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("1dlu"),}));
		
		JLabel lblNewLabel = new JLabel("Title:");
		frame.getContentPane().add(lblNewLabel, "2, 2");
		
		textField = new JTextField();
		frame.getContentPane().add(textField, "4, 2, 5, 1, fill, default");
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Time:");
		frame.getContentPane().add(lblNewLabel_3, "2, 4");
		
		final JDatePicker datePicker = JDateComponentFactory.createJDatePicker(new UtilDateModel(new Date()));
		datePicker.setTextEditable(true);
		datePicker.setShowYearButtons(true);
		frame.getContentPane().add((JComponent)datePicker, "4, 4, 3, 1");
		
		final JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
		timeSpinner.setEditor(timeEditor);
		timeSpinner.setValue(new Date());
		frame.getContentPane().add(timeSpinner, "8, 4, fill, fill");
		
		JLabel lblNewLabel_1 = new JLabel("Message:");
		frame.getContentPane().add(lblNewLabel_1, "2, 6");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		frame.getContentPane().add(scrollPane, "2, 8, 7, 1, fill, fill");
		
		final JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("Remind on:");
		frame.getContentPane().add(lblNewLabel_2, "2, 10");
		
		final JDatePicker datePicker_1 = JDateComponentFactory.createJDatePicker(new UtilDateModel(new Date()));
		datePicker_1.setTextEditable(true);
		datePicker_1.setShowYearButtons(true);
		frame.getContentPane().add((JComponent)datePicker_1, "4, 10, 3, 1");
//		datePicker_1.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				System.out.println(datePicker_1.getModel());
//			}
//		});
		
		final JSpinner timeSpinner_1 = new JSpinner( new SpinnerDateModel() );
		JSpinner.DateEditor timeEditor_1 = new JSpinner.DateEditor(timeSpinner_1, "HH:mm:ss");
		timeSpinner_1.setEditor(timeEditor_1);
		timeSpinner_1.setValue(new Date());
		frame.getContentPane().add(timeSpinner_1, "8, 10, 1, 1");
//		timeSpinner_1.addChangeListener(new ChangeListener() {
//			@Override
//			public void stateChanged(ChangeEvent paramChangeEvent) {
//				Date date = (Date)(timeSpinner_1.getValue());				
//				if (datePicker_1.getModel() != null) {
//					DateModel dateModel = datePicker_1.getModel();
//					date.setYear(dateModel.getYear());
//					date.setMonth(dateModel.getMonth());
//					date.setDate(dateModel.getDay());
//				}
//				System.out.println(date + " " + date.getYear());
//			}
//		});
		
		btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				NotificationManager notificationManager = NotificationManager.getInstance();
				
				Date eventDate = (Date)(timeSpinner.getValue());				
				if (datePicker.getModel() != null) {
					DateModel dateModel = datePicker.getModel();
					eventDate.setYear(dateModel.getYear() - 1900);
					eventDate.setMonth(dateModel.getMonth());
					eventDate.setDate(dateModel.getDay());
				}
				
				Date notificationDate = (Date)(timeSpinner_1.getValue());				
				if (datePicker_1.getModel() != null) {
					DateModel dateModel = datePicker_1.getModel();
					notificationDate.setYear(dateModel.getYear() - 1900);
					notificationDate.setMonth(dateModel.getMonth());
					notificationDate.setDate(dateModel.getDay());
				}
				
				notificationManager.addNotification(new Notification(textField.getText(),textArea.getText(), eventDate, notificationDate));
				
				DefaultListModel innerListModel = new DefaultListModel();
		    	
				ArrayList<Notification> notifications = notificationManager.getNotifications();
				
				for (Notification notification : notifications) {
					innerListModel.add(notifications.indexOf(notification), notification.toShortString());
				}
				list.setModel(innerListModel);
				list.repaint();
				
				getFrame().setVisible(false);
			}
		});
		frame.getContentPane().add(btnNewButton, "6, 12");
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				getFrame().setVisible(false);
			}
		});
		frame.getContentPane().add(btnNewButton_1, "8, 12");
	}

	public JFrame getFrame() {
		return frame;
	}
}
