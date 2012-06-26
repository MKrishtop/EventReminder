package name.mikhailkrishtop.ui;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class EventReminderComponent extends JFrame{
	
	public EventReminderComponent(String title) {
		super(title);
		
		ImageIcon addNotificationImage = new ImageIcon("add.png");
		ImageIcon deleteNotificationImage = new ImageIcon("delete.png");
		ImageIcon emailImage = new ImageIcon("email.png");
		
		JButton addNotificationButton = new JButton(null, addNotificationImage);
		JButton deleteNotificationButton = new JButton(null, deleteNotificationImage);
		JButton emailButton = new JButton(null, emailImage);
		
		addNotificationButton.setFocusable(false);
		deleteNotificationButton.setFocusable(false);
		emailButton.setFocusable(false);

		GroupLayout layout = new GroupLayout(this);

		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		layout.setHorizontalGroup(
				   layout.createSequentialGroup()
				      .addComponent(addNotificationButton)
				      .addComponent(deleteNotificationButton)
				      .addComponent(emailButton)
				);
		layout.setVerticalGroup(
				   layout.createSequentialGroup()
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				           .addComponent(addNotificationButton)
				           .addComponent(deleteNotificationButton)
				           .addComponent(emailButton))
				);
		
		
	    this.setLayout(layout);
	    this.add(addNotificationButton);
	    this.add(deleteNotificationButton);
	    this.add(emailButton);

//	    this.setSize(new Dimension(250, 80));
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}
