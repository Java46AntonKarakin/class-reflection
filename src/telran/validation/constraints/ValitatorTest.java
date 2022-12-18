package telran.validation.constraints;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import telran.annotation.examples.Person;

public class ValitatorTest {

	@Test
	void someTest() throws Exception {
		Person human = new Person(123, "1Vasya", 150, -50, 50, "TalkingIslandVillage");
		ArrayList<String> res = Validator.validate(human);
		System.out.println(res.size());
		for (String str: res) {
			System.out.println(str);
		}
	}
}
