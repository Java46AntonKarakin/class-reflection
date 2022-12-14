package telran.messages.application;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import telran.messages.Message;
import telran.view.InputOutput;
import telran.view.Item;

public class ItemSender implements Item {
	private static final String BASE_PACKAGE = "telran.messages.";
	private String inputValue;
	private Message message;
	private Class<Message> clazz;
	private Constructor<Message> constructor;

	@Override
	public String displayName() {
		return "Send message";
	}

	@SuppressWarnings("unchecked")
	@Override
	public void perform(InputOutput io) {
		try {
			inputValue = io.readString("Message type: ");
			clazz = (Class<Message>) Class.forName(BASE_PACKAGE + inputValue);
			constructor = clazz.getConstructor(String.class);
			inputValue = getAdress(io);
			message = constructor.newInstance(inputValue);
			inputValue = io.readString("Message text: ");
			message.send(inputValue);
		} catch (ClassNotFoundException e) {
			io.writeLine("wrong class name. Try again.");
			perform(io);
		} catch (IllegalAccessException e) {
			io.writeLine("wrong address. Try again.");
			perform(io);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getAdress(InputOutput io)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		String regex = clazz.getMethod("getRegex").invoke(null).toString();
		return io.readPredicate(String.format("insert adress according to message type: %s", clazz.getName()),
				"wrong address. Try again.", adress -> {
					return adress.matches(regex);
				});
	}

	@Override
	public boolean isExit() {
		return false;
	}
}
