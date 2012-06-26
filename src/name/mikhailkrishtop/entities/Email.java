package name.mikhailkrishtop.entities;

public class Email {
	private String email = "none";
	private String password = "none";

	public Email(String email) {
		this.email = email;
	}
	
	public Email(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return "email: " + email + "; password: " + password ;
	}
}
