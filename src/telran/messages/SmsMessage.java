package telran.messages;

public class SmsMessage implements Message {
	
	private String phoneNumber;
	private static String phoneNumberFormat = "(\\+[0-999]{12})";
	
	public static final String getRegex() {
		return phoneNumberFormat;
	}

	public SmsMessage(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void send(String text) {
		System.out.printf("Sms message '%s' has been sent to phone number %s%n", text, phoneNumber);
	}
}
