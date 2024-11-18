package service;

import java.util.*;
import model.*;

public class Main {

    public static void main(String[] args) {
        PersonService personsInfo = new PersonService();

        Scanner in = new Scanner(System.in);

        System.out.println("Enter you First name: ");
        String firstName = in.nextLine();
        System.out.println("Enter you Last name: ");
        String lastName = in.nextLine();
        System.out.println("Enter you Surname: ");
        String surname = in.nextLine();
        System.out.println("Enter you age: ");
        int age = in.nextInt();
        in.nextLine();
        System.out.println("Enter you nation: ");
        String nation = in.nextLine();
        System.out.println("Enter you gender (male/female): ");
        String sex = in.nextLine();

        if ("male".equalsIgnoreCase(sex)) {
            personsInfo.save(new Man(firstName, lastName, surname, age, nation));
        } else if ("female".equalsIgnoreCase(sex)) {
            personsInfo.save(new Woman(firstName, lastName, surname, age, nation));
        } else {
            System.out.println("Invalid gender entered!");
        }

        personsInfo.getAll();
    }
}
