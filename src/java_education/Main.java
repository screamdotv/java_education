package java_education;

import java_education.init.*;

public class Main {

    public static void main(String[] args) {
        PersonInitialize createPerson = new PersonInitialize();

        createPerson.init();
        
        createPerson.service.getAll();
    }
}
