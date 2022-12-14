package telran.messages.application;

import java.util.ArrayList;
import telran.view.*;

public class MessageAppl {
	
	public static void main(String[] args) {
		ArrayList<Item> items = getItems();
		Menu menu = new Menu("my menu", items);
		menu.perform(new ConsoleInputOutput());
	}

	private static ArrayList<Item> getItems() {
		ArrayList<Item> res = new ArrayList<>();
		res.add(new ItemSender());
		res.add(Item.exit());
		return res;
	}
}
