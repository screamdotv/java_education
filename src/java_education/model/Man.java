package java_education.model;

public class Man extends Person {

    protected String sex = "male";

    public Man(String firstName, String lastName, String surname, int age, String nation) {
        super(firstName, lastName, surname, age, nation);
    }

    public Man() {
    }

    @Override
    public String toString() {
        String result = super.toString();
        return result + "sex: " + sex + ";";
    }
}
