package practise;

public class Person {
	protected String firstName;
	protected String lastName;
	protected String surname;
	protected int age;
	protected String nation;

	Person(String firstName, String lastName, String surname, int age, String nation) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.surname = surname;
		this.age = age;
		this.nation = nation;
	}

	public String getName() {
		return this.firstName;
	}
}
