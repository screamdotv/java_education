package model;

public class Man extends Person {
	protected String sex = "male"; 
	
	public Man(String firstName, String lastName, String surname, int age, String nation) {
		super(firstName, lastName, surname, age, nation);
	}
	
	@Override
	public String toString() {
		return "Persone {" + "firstName = " + firstName + "; " + "nation = " + nation + "; " + "sex = " + sex + ";"
				+ "}";
	}
}
