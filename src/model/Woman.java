package model;

public class Woman extends Person {
	protected String sex = "female";

	public Woman(String firstName, String lastName, String surname, int age, String nation) {
		super(firstName, lastName, surname, age, nation);
	}

	@Override
	public String toString() {
		return "Persone {" + "firstName = " + firstName + "; " + "nation = " + nation + "; " + "sex = " + sex + ";"
				+ "}";
	}
}
