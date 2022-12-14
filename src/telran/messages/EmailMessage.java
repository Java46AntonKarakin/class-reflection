package telran.messages;

public class EmailMessage implements Message {
	private String emailAddress;
	private static String emailAddressFormat = ".+@.+\\..+";

	public EmailMessage(String emailAdress) {
		this.emailAddress = emailAdress;
	}

	public static final String getRegex() {
		return emailAddressFormat;
	}

	public void send(String text) {
		System.out.printf("Email message '%s' has been sent to email address %s%n", text, emailAddress);
	}
}
