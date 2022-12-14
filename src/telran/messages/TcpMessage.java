package telran.messages;

public class TcpMessage implements Message {
	private String ipPort;	// ipv4:port
	private static String ipPortFormat = "((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\:([\\d]{4,6})";	

	public TcpMessage(String ipPort) {
		this.ipPort = ipPort;
	}

	public static final String getRegex() {
		return ipPortFormat;
	}
	
	public void send(String text) {
		System.out.printf("tcp message '%s' has been sent to ip:port %s%n", text, ipPort);
	}
}
