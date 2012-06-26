package name.mikhailkrishtop.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import name.mikhailkrishtop.entities.Email;
import name.mikhailkrishtop.managers.EmailManager;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class EmailsForm {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmailsForm window = new EmailsForm();
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
	public EmailsForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 280);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
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
				RowSpec.decode("1dlu"),}));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Gmail account", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel, "2, 2, 5, 1, fill, fill");
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("Login:");
		panel.add(lblNewLabel, "1, 1, right, default");
		
		textField = new JTextField();
		panel.add(textField, "3, 1, fill, default");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		panel.add(lblNewLabel_1, "5, 1, right, default");
		
		textField_1 = new JPasswordField();
		panel.add(textField_1, "7, 1, fill, default");
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "To", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(panel_1, "2, 4, 5, 1, fill, fill");
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.GROWING_BUTTON_COLSPEC,},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel_2 = new JLabel("Email 1:");
		panel_1.add(lblNewLabel_2, "1, 1, left, default");
		
		textField_2 = new JTextField();
		panel_1.add(textField_2, "3, 1, fill, default");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Email 2:");
		panel_1.add(lblNewLabel_4, "1, 3, left, default");
		
		textField_3 = new JTextField();
		panel_1.add(textField_3, "3, 3, fill, default");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email 3:");
		panel_1.add(lblNewLabel_3, "1, 5, left, default");
		
		textField_4 = new JTextField();
		panel_1.add(textField_4, "3, 5, fill, default");
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Email 4:");
		panel_1.add(lblNewLabel_5, "1, 7, left, default");
		
		textField_6 = new JTextField();
		panel_1.add(textField_6, "3, 7, fill, default");
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Email 5:");
		panel_1.add(lblNewLabel_6, "1, 9, left, default");
		
		textField_5 = new JTextField();
		panel_1.add(textField_5, "3, 9, fill, default");
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Email> emails = new ArrayList<Email>();
				EmailManager emailManager = EmailManager.getInstance();
				
				emails.add(new Email(textField.getText(),textField_1.getText()));

				emails.add(new Email(textField_2.getText()));
				emails.add(new Email(textField_3.getText()));
				emails.add(new Email(textField_4.getText()));
				emails.add(new Email(textField_5.getText()));
				emails.add(new Email(textField_6.getText()));
				
				emailManager.setEmails(emails);
				
				getFrame().setVisible(false);
			}
		});
		frame.getContentPane().add(btnNewButton, "4, 6");
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				getFrame().setVisible(false);
			}
		});
		frame.getContentPane().add(btnNewButton_1, "6, 6");
		
		EmailManager emailManager = EmailManager.getInstance();
		
		ArrayList<Email> emails = emailManager.getEmails();
		ArrayList<Email> emailsCopy = new ArrayList<Email>();

		
		for (Email email : emails) {
			if (!(email.getPassword().equalsIgnoreCase("none"))) {
				textField.setText(email.getEmail());
				textField_1.setText(email.getPassword());
			} else {
				emailsCopy.add(email);
			}
		}
		
		if (emailsCopy.size() > 0) {
			textField_2.setText(emailsCopy.get(0).getEmail());
			if (emailsCopy.size() > 1) {
				textField_3.setText(emailsCopy.get(1).getEmail());
				if (emailsCopy.size() > 2) {
					textField_4.setText(emailsCopy.get(2).getEmail());
					if (emailsCopy.size() > 3) {
						textField_5.setText(emailsCopy.get(3).getEmail());
						if (emailsCopy.size() > 4) {
							textField_6.setText(emailsCopy.get(4).getEmail());
						}
					}
				}
			}
		}
	}

	public JFrame getFrame() {
		return frame;
	}
}
