package telran.annotation.examples;

import telran.annotation.*;

public class Person {

	public Person(long id, String name, int power, int agility, int stamina, String birthVillage) {
		super();
		this.id = id;
		this.name = name;
		this.power = power;
		this.agility = agility;
		this.stamina = stamina;
		this.birthVillage = birthVillage;
	}
	
	public Person(long id, String name) {
		this(id, name, 0, 0, 0, null);
	}

	@Id
	private long id;

	@NotEmpty
	@Pattern("[A-Z][a-z]{1,10}")
	private String name;

	@Max(100)
	@Min(0)
	private int power;

	@Max(100)
	@Min(0)
	private int agility;

	@Max(100)
	@Min(0)
	private int stamina;

	@NotEmpty
	private String birthVillage;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
