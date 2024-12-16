package java_education.model;

public abstract class Person {

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

    Person() {
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getSurname() {
        return this.surname;
    }

    public int getAge() {
        return this.age;
    }
    
    public String getNation(){
        return this.nation;
    }
    
    public abstract String getGander();

    @Override
    public String toString() {
        return "firstName: " + firstName + "; " + "lastName: " + lastName + "; " + "age: " + age + "; " + "nation: " + nation + "; ";
    }

}
