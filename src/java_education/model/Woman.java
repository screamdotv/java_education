package java_education.model;

public class Woman extends Person {

    protected String sex = "female";

    public Woman(String firstName, String lastName, String surname, int age, String nation) {
        super(firstName, lastName, surname, age, nation);
    }

    public Woman() {
    }

    @Override
    public String toString() {
        String result = super.toString();
        return result + "sex: " + sex + ";";
    }
}
