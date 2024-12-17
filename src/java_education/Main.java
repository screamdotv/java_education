package java_education;

import java.util.*;
import java_education.init.*;
import java_education.service.*;
import java_education.model.*;

public class Main {

    private Map<String, String> questionsList = new LinkedHashMap<>();
    private Scanner scannerInput = new Scanner(System.in);
    private PersonService service = PersonServiceConnection.getPersonService();

    private void initData() {
        new PersonInitialize().init();
    }

    private void doStudyTasks() {
        Collection<Person> persons = service.getAll();
        persons.forEach(System.out::println);
    }

    private void initListQuestion() {
        this.questionsList.put("gender", "Enter your gender (male/female): ");
        this.questionsList.put("firstName", "Enter your First Name: ");
        this.questionsList.put("lastName", "Enter your Last Name: ");
        this.questionsList.put("surname", "Enter your Surname: ");
        this.questionsList.put("nation", "Enter your nation: ");
        this.questionsList.put("age", "Enter your age: ");
    }

    public void startRegistration() {
        Person person = null;
        boolean start = true;
        MatchService match = new MatchService();
        boolean correctGander = false;

        while (start) {
            for (Map.Entry<String, String> question : questionsList.entrySet()) {
                System.out.print(question.getValue());
                String inputValue = scannerInput.nextLine();

                if ("exit".equalsIgnoreCase(inputValue)) {
                    start = false;
                    break;
                }

                if ("gender".equals(question.getKey())) {
                    person = createGenderPerson(inputValue);
                }

                if (person != null) {
                    handleQuestionInput(person, question.getKey(), inputValue);
                    start = false;
                } else {
                    System.out.println("Gender must be set before entering other details.");
                    break;
                }
            }
        }

        scannerInput.close();

        service.save(person);
        Collection<Person> matchListPesron = match.matchPerson(person);
        matchListPesron.forEach(System.out::println);
    }

    private Person createGenderPerson(String gander) {
        if ("male".equalsIgnoreCase(gander)) {
            return new Man();
        } else if ("female".equalsIgnoreCase(gander)) {
            return new Woman();
        }
        return null;
    }

    private void handleQuestionInput(Person person, String key, String inputValue) {
        switch (key) {
            case "firstName" ->
                person.setFirstName(inputValue);
            case "lastName" ->
                person.setLastName(inputValue);
            case "surname" ->
                person.setSurname(inputValue);
            case "nation" ->
                person.setNation(inputValue);
            case "age" ->
                handleAgeInput(person, inputValue, key);

        }
    }

    private void handleAgeInput(Person person, String inputValue, String questionKey) {
        boolean correctNum = false;

        while (!correctNum) {
            try {
                person.setAge(Integer.parseInt(inputValue));
                correctNum = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid age. Please enter a number.");
                System.out.print(questionsList.get(questionKey));
                inputValue = scannerInput.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();

        main.initData();
        main.initListQuestion();
        main.startRegistration();
        System.out.println();
        System.out.println();
        System.out.println();
        main.doStudyTasks();
    }

}
