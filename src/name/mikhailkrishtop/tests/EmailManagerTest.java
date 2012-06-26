package name.mikhailkrishtop.tests;

import java.util.ArrayList;

import name.mikhailkrishtop.entities.Email;
import name.mikhailkrishtop.managers.EmailManager;

public class EmailManagerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EmailManager emailManager = EmailManager.getInstance();
		
		ArrayList<Email> emails = new ArrayList<Email>();
		
		emails.add(new Email("qwe"));
		emails.add(new Email("rty"));
		emails.add(new Email("asd"));
		emails.add(new Email("fgh", "pass"));	
		emailManager.setEmails(emails);
		
		ArrayList<Email> emails1 = emailManager.getEmails();
		
		for (Email email : emails1) {
			System.out.println(email);
		}
		
		System.out.println("EmailManagerTest done.");
	}

}
