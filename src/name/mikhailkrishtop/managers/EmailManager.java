package name.mikhailkrishtop.managers;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import name.mikhailkrishtop.entities.Email;
import name.mikhailkrishtop.entities.Notification;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class EmailManager {

	private static EmailManager m_instance;
	private ArrayList<Email> m_emails = null;
	private static final String DATA_FILEPATH = "data/emails.xml";

	private EmailManager() {
	}

	public static synchronized EmailManager getInstance() {
		if (m_instance == null) {
			m_instance = new EmailManager();
		}
		return m_instance;
	}

	public ArrayList<Email> getEmails() {
		if (m_emails == null) {
			m_emails = readEmails(DATA_FILEPATH);
		}

		return m_emails;
	}

	public void setEmails(ArrayList<Email> emails) {
		m_emails = emails;

		XStream xStream = new XStream(new DomDriver());
		xStream.alias("email", Email.class);
		Random rand = new Random();

		int counter = 0;
		while (counter++ < 20) {
			try {
				xStream.toXML(m_emails, new FileWriter(DATA_FILEPATH));
				return;
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

	private ArrayList<Email> readEmails(String filepath) {
		XStream xStream = new XStream(new DomDriver());
		xStream.alias("email", Email.class);
		Random rand = new Random();

		int counter = 0;
		while (counter++ < 20) {
			try {
				return (ArrayList<Email>) xStream.fromXML(new FileReader(filepath));
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
		return new ArrayList<Email>();
	}
}
