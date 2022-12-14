package telran.tests;

import java.lang.reflect.Method;

public class TestAppl {
	
	public static void main(String[] args)  throws Exception {
		if (args.length < 2) {
			System.out.println(
					"too few arguments: usage - first argument is message type, second - adress");
		} else {
			Tests tests = new Tests();
			Method method = tests.getClass().getDeclaredMethod(args[0], String.class);
			method.setAccessible(true);
			method.invoke(tests, args[1]);
		}
	}
}
