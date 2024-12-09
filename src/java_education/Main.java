package java_education;

import java.util.*;
import java_education.init.*;
import java_education.service.*;
import java_education.model.*;

public class Main {

    public static void main(String[] args) {
        PersonService service = PersonServiceConnection.getPersonService();
        initData();

        Scanner scannerInput = new Scanner(System.in);

        Map<String, String> questionsList = new LinkedHashMap<>();
        questionsList.put("gender", "Enter your gender (male/female): ");
        questionsList.put("firstName", "Enter your First Name: ");
        questionsList.put("lastName", "Enter your Last Name: ");
        questionsList.put("surname", "Enter your Surname: ");
        questionsList.put("nation", "Enter your nation: ");
        questionsList.put("age", "Enter your age: ");

        boolean start = true;

        String gender;
        String firstName = "";
        String lastName = "";
        String surname = "";
        String nation = "";
        int age = 0;

        Person person = null;

        System.out.print(questionsList.get("gender"));
        String inputValue = scannerInput.nextLine();

        if ("male".equalsIgnoreCase(inputValue)) {
            person = new Man();
        } else if ("female".equalsIgnoreCase(inputValue)) {
            person = new Woman();
        } else if ("exit".equalsIgnoreCase(inputValue)) {
            start = false;
        }

        while (start) {
            for (Map.Entry<String, String> question : questionsList.entrySet()) {
                System.out.print(question.getValue());
                inputValue = scannerInput.nextLine();

                if ("exit".equalsIgnoreCase(inputValue)) {
                    start = false;
                    break;
                }
            
                switch (question.getKey()) {
                    case "firstName" ->
                        person.setFirstName(inputValue);
                    case "lastName" ->
                        person.setLastName(inputValue);
                    case "surname" ->
                        person.setSurname(inputValue);
                    case "nation" ->
                        person.setNation(inputValue);
                    case "age" -> {
                        boolean correctNum = false;
                        while (!correctNum) {
                            try {
                                person.setAge(Integer.parseInt(inputValue));
                                correctNum = true;
                                start = false;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid age. Please enter a number.");
                                System.out.print(question.getValue());
                                inputValue = scannerInput.nextLine();
                            }
                        }
                    }
                }
            }
            scannerInput.close();
        }
    }

    private static void initData() {
        new PersonInitialize().init();
    }

    private static void doStudyTasks() {
        PersonService service = PersonServiceConnection.getPersonService();
        Collection<Person> persons = service.getAll();
        persons.forEach(System.out::println);
    }

}
